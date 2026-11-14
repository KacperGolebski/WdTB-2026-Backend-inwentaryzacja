-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: konta zespołu z adresami testowymi.
insert into user_account (email, display_name, role, created_at) values
    ('kacper.golebski@example.com', 'Kacper Gołębski', 'USER', current_timestamp),
    ('tomasz.choragwicki@example.com', 'Tomasz Chorągwicki', 'USER', current_timestamp),
    ('konto-testowe@example.com', 'Konto testowe', 'USER', current_timestamp);

-- ===== LAB 02 · equipment =====
insert into equipment (inventory_number, name, serial_number, status, building, room) values
    ('EQ-001', 'Laptop Dell Latitude 5450', 'DL-5450-001', 'ASSIGNED', 'Biuro główne', 'A-204'),
    ('EQ-002', 'Monitor Lenovo ThinkVision T24i', 'LN-T24I-002', 'AVAILABLE', 'Biuro główne', 'Magazyn IT'),
    ('EQ-003', 'Drukarka Brother HL-L5210DW', 'BR-L5210-003', 'IN_REPAIR', 'Budynek techniczny', 'Serwis');

-- ===== LAB 02 · employee =====
insert into employee (employee_number, full_name, work_email, department) values
    ('EMP-001', 'Anna Nowak', 'anna.nowak@example.com', 'Administracja'),
    ('EMP-002', 'Piotr Zieliński', 'piotr.zielinski@example.com', 'IT'),
    ('EMP-003', 'Marta Kowalczyk', 'marta.kowalczyk@example.com', 'Księgowość');

-- ===== LAB 02 · inventory_check =====
insert into inventory_check (reference_number, scope, checked_on, checked_item_count, discrepancy_count) values
    ('INV-2026-001', 'Laptopy w biurze głównym', '2026-10-21', 18, 0),
    ('INV-2026-002', 'Monitory w magazynie IT', '2026-10-28', 12, 1),
    ('INV-2026-003', 'Drukarki w budynku technicznym', '2026-11-06', 7, 0);
