// src/pages/pharmacist/PharmacistDashboard.jsx

import Navbar from "../../components/Navbar";
import { useAuth } from "../../context/AuthContext";

export default function PharmacistDashboard() {
  const { user } = useAuth();
  return (
    <>
      <Navbar />
      <div className="container" style={{ paddingTop: 40 }}>
        <p style={{ fontSize: 13, color: "var(--text-muted)", marginBottom: 4 }}>Pharmacist Portal</p>
        <h1 style={{ fontSize: 28, fontWeight: 600, marginBottom: 8 }}>Welcome, {user?.name}</h1>
        <div className="accent-line" />
        <div className="card" style={{ marginTop: 32, padding: 24 }}>
          <p style={{ color: "var(--text-muted)" }}>
            Pharmacist features (medicine inventory, dispensing queue) coming soon.
          </p>
        </div>
      </div>
    </>
  );
}