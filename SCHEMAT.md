# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 4 · kolumny: 24 · relacje: 1 × @ManyToOne, 0 × @OneToMany, 0 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| employee | Employee | 5 | — |
| equipment | Equipment | 7 | — |
| inventory_check | InventoryCheck | 7 | employee_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    employee {
        Long id PK
        String department
        String employee_number
        String full_name
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
    employee ||--o{ inventory_check : "employee_id"
```
