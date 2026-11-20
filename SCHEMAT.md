# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 5 · kolumny: 30 · relacje: 3 × @ManyToOne, 0 × @OneToMany, 1 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| employee | Employee | 6 | user_account_id |
| equipment | Equipment | 7 | — |
| equipment_assignment | EquipmentAssignment | 5 | employee_id, equipment_id |
| inventory_check | InventoryCheck | 7 | employee_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    employee {
        Long id PK
        String department
        String employee_number
        String full_name
        Long user_account_id FK
        String work_email
    }
    equipment {
        Long id PK
        String building
        String inventory_number
        String name
        String room
        String serial_number
        EquipmentStatus status
    }
    equipment_assignment {
        Long id PK
        LocalDate assigned_on
        Long employee_id FK
        Long equipment_id FK
        LocalDate returned_on
    }
    inventory_check {
        Long id PK
        int checked_item_count
        LocalDate checked_on
        int discrepancy_count
        Long employee_id FK
        String reference_number
        String scope
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    employee ||--o{ equipment_assignment : "employee_id"
    employee ||--o{ inventory_check : "employee_id"
    equipment ||--o{ equipment_assignment : "equipment_id"
    user_account |o--o| employee : "user_account_id"
```
