import express from "express";
import userRouter from "./routes/userRoutes.js"
import authRouter from "./routes/authRoutes.js"
import { config } from "dotenv";
import { connectDB, disconnectDB } from "./config/db.js";


config();
connectDB();

const app = express();

app.use(express.json());



app.use("/users", userRouter);
app.use("/auth", authRouter);




const PORT = 5001
app.listen(PORT,() =>{

	console.log(`Server running on port ${PORT}`)
})

process.on("unhandledRejection", (err) => {
	console.error("Unhandled Rejection", err);
	server.close( async () => {
		await disconnectDB();
		process.exit(1);
	})
})

process.on("uncaughtException", async (err) => {
	console.error("Uncaught Exception", err);
	
		await disconnectDB();
		process.exit(1);
})

process.on("SIGTERM", async () => {
	console.error("SIGTERM received, shutting down gracefully", err);
	server.close(async () => {
		await disconnectDB();
		process.exit(1);
	})
		
})


//  get post put delete

// AUTH
// User
// Event
// Profile