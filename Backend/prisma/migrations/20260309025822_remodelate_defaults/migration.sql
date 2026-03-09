-- AlterTable
ALTER TABLE "Event" ALTER COLUMN "bool_company" SET DEFAULT false,
ALTER COLUMN "company_per_guest" SET DEFAULT 1,
ALTER COLUMN "guestLimit" SET DEFAULT true,
ALTER COLUMN "status" SET DEFAULT 'UNSTARTED';

-- AlterTable
ALTER TABLE "EventGuest" ALTER COLUMN "role" SET DEFAULT 'GUEST';
