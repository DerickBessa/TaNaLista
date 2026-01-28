package io.github.TaNaLista.tanalista.Service;

import io.github.TaNaLista.tanalista.DTO.NotificationDTO;
import io.github.TaNaLista.tanalista.Model.Notification;
import io.github.TaNaLista.tanalista.Model.ENUM.NotificationType;
import io.github.TaNaLista.tanalista.Repository.NotificationRepository;
import io.github.TaNaLista.tanalista.Repository.EventRepository;
import io.github.TaNaLista.tanalista.Model.Event;
import io.github.TaNaLista.tanalista.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final EventRepository eventRepository;

    public NotificationService(NotificationRepository notificationRepository,
                               EventRepository eventRepository) {
        this.notificationRepository = notificationRepository;
        this.eventRepository = eventRepository;
    }

    // Cria e persiste uma notificação a partir do DTO
    @Transactional
    public NotificationDTO createNotification(NotificationDTO dto) {
        Notification notification = dto.toEntity();
        if (notification.getDate() == null) {
            // define data atual se não fornecida
            notification = new Notification(notification.getDescription(), notification.getTypeNotification(), LocalDateTime.now());
        }
        Notification saved = notificationRepository.save(notification);
        return new NotificationDTO(saved);
    }

    // Registra uma notificação relacionada a um evento (por exemplo: alteração de horário/local/mensagem do admin)
    // OBS: o modelo atual não tem relação direta Notification <-> Guest/User, então aqui criamos uma notificação
    // genérica vinculada ao evento (descrição contendo o nome do evento). A entrega para convidados/admin
    // fica a cargo da camada de entrega (e-mail/push) ou de um ajuste futuro no modelo.
    @Transactional
    public NotificationDTO notifyGuestsByEvent(UUID eventId, String message, NotificationType type) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado: " + eventId));

        String description = "Evento '" + event.getName() + "' - " + message;
        Notification notification = new Notification(description, type, LocalDateTime.now());
        Notification saved = notificationRepository.save(notification);
        return new NotificationDTO(saved);
    }

    // Notifica o administrador do evento sobre ações importantes (ex: novo convidado, confirmação).
    // Como não há campo de admin na entidade Event atualmente, este método apenas cria uma notificação
    // com referência textual ao evento; associar ao usuário admin exige alteração do modelo.
    @Transactional
    public NotificationDTO notifyAdminEvent(UUID eventId, String message, NotificationType type) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado: " + eventId));

        String description = "Para administrador do evento '" + event.getName() + "': " + message;
        Notification notification = new Notification(description, type, LocalDateTime.now());
        Notification saved = notificationRepository.save(notification);

        return new NotificationDTO(saved);
    }

    // Lista notificações (todas)
    @Transactional(readOnly = true)
    public List<NotificationDTO> listAll() {
        return notificationRepository.findAll().stream().map(NotificationDTO::new).collect(Collectors.toList());
    }

    // Busca notificações por descrição (busca parcial)
    @Transactional(readOnly = true)
    public List<NotificationDTO> searchByDescription(String description) {
        return notificationRepository.findByDescriptionContainingIgnoreCase(description).stream()
                .map(NotificationDTO::new).collect(Collectors.toList());
    }

    // Marca uma notificação como lida — atualmente Notification não possui campo 'read', então método placeholder
    @Transactional
    public void markAsRead(UUID notificationId) {
        // Se Notification tivesse um campo `read` deveríamos buscá-la, setar e salvar.
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notificação não encontrada: " + notificationId));
        // comportamento placeholder: não há campo para atualizar
    }
}
