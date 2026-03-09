import { prisma } from "../config/db.js";
import bcrypt from "bcryptjs";
import { generateToken} from "../utils/generateToken.js";

const register = async (req, res) =>{
	const {name, email, password, cpf, login} = req.body;
		const userExists = await prisma.user.findUnique({
			where: {email: email},
		})

		const cpfExists = await prisma.user.findUnique({
			where: {cpf: cpf},
		})

		if (userExists || cpfExists){
			return res
			.status(400)
			.json({error: "User already exists with this email"})
		}

	//has Password
	const salt = await bcrypt.genSalt(10) //$2b$10
	const hashedPassword = await bcrypt.hash(password, salt);

	const user = await prisma.user.create({
		data:{
			name,
			cpf,
			email,
			login,
			password: hashedPassword,
		}
	})
	const token = generateToken(user.id);

	

	res.status(201).json({
		status:"success Register",
		data: {
			user: {
				id: user.id,
				name:name,
				email:email,
				cpf:`${cpf.slice(0,3)}.***.***-*${cpf.slice(-1)}`,
			},
			token,

		}
	})
};

const login = async (req, res) =>{
	const {identifier , password} = req.body
	console.log(req.body)

	const user = await prisma.user.findFirst({
		where: {
			OR:[
				{email: identifier},
				{login: identifier}
			]
		}
	})

	if (!user){
			return res
			.status(401)
			.json({error:"Invalid Login/Password!"})
		}

	const isPasswordValid = await bcrypt.compare(password, user.password);

	if (!isPasswordValid){
			return res
			.status(401)
			.json({error:"Invalid Login/Password!"})
		}
	
		// JWT Token
	const token = generateToken(user.id, res);


	

	res.status(201).json({
		status:"Success Login",
		data: {
			user: {
				id: user.id,
				email:user.email,
				cpf:`${user.cpf.slice(0,3)}.***.***-*${user.cpf.slice(-1)}`,
			},
			token,
		}
	});
	};
	const logout = async (req,res) =>{

		res.cookie("jwt", "", {
			expires: new Date(0)
		})

		res.status(200).json({

			status:"success",
			message:"Logged out sucessfully"
		});
	};

export {register, login, logout}