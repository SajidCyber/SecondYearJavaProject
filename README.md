# SecondYearJavaProject
# Community Skill & Resource Exchange Platform

## Project Overview
This is a **Java-based Community Skill & Resource Exchange Platform** that allows users to offer or request skills and resources.  
The system supports **multi-language interaction, user management, matching logic, and database storage** in future phases.  
It is designed to be **scalable**, moving from a simple console program to a full-fledged **JavaFX GUI with MySQL backend**.

---

## Features

### Phase 1 – Console Application
- **User Management** – Login/Signup with basic validation.    
- **Terms & Policies** – Users must accept before proceeding.  
- **Offer or Request Flow**:
  - **Offer**: Enter skill/item, duration, availability, optional cost.  
  - **Request**: Enter skill/item needed, duration.  
- **Matching Logic** – Matches requests with offers based on:
  - Skill/Item availability  
  - Duration compatibility  
  - Price visibility (if applicable)  
-  **Descriptions** – Users can describe what they offer/request.  

### Phase 2 – Database Integration
-  **MySQL Storage** – Users, offers, requests stored persistently.  
-  **Payment Handling** – Cost calculation for item lending.  
-  **Transaction History** – Track past offers/requests.  

### Phase 3 – JavaFX GUI
-  **Interactive Dashboard** with modern UI.  
-  **Multi-Language Labels** – Full UI localization.  
-  **Search & Filter** – Find offers/requests quickly.  
-  **Notifications** – Alerts when matches are found.  
-  **Calendar & Time Pickers** – For scheduling.  
-  **History View** – Users can see past activities.  

---
##  How to Run
### Compile
```bash
javac app\model\*.java app\service\*.java app\CommunityExchange.java

java app.CommunityExchange


##  Project Structure
