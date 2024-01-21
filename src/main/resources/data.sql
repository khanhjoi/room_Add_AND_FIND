INSERT INTO room_type (id, language_code, name_type, parent_id, is_delete)
VALUES ('562013bb-8c9e-41db-b934-632e64885d80', 'vn', 'tiêu chuẩn', 'b6e23e77-143d-4b2f-b378-95b6bd5c3c77', false),
        ('b6e23e77-143d-4b2f-b378-95b6bd5c3c77', 'en', 'standrand', '562013bb-8c9e-41db-b934-632e64885d80', false),
        ('bc6d5c31-6dd6-47aa-af8a-bb82b9eff032', 'vn', 'sang trọng', 'dde03ff7-68de-456d-b035-dca30a74889b', false),
        ('dde03ff7-68de-456d-b035-dca30a74889b', 'en', 'luxury', 'bc6d5c31-6dd6-47aa-af8a-bb82b9eff032', false);

INSERT INTO room_utility (id, parentId,language_code,name, type, is_delete)
VALUES ('9af8c8b8-55e8-4765-88cb-f2e3747a5f38','617512bc-fd32-4be1-a1e9-62463e81e961', 'vn', 'Bang công', 'cơ sở vật chất', false),
       ('617512bc-fd32-4be1-a1e9-62463e81e961','9af8c8b8-55e8-4765-88cb-f2e3747a5f38','en', 'balcony', 'infrastructure', false),
       ('23861153-0b4d-4d18-be03-0c13c34c9c55','e6f77d50-9d7a-423e-a7c8-ef10531ecd6c', 'vn', 'Máy lạnh', 'dịch vụ', false),
       ('e6f77d50-9d7a-423e-a7c8-ef10531ecd6c','23861153-0b4d-4d18-be03-0c13c34c9c55', 'en', 'air-conditioner', 'service', false),
       ('4755b305-f9b1-4c44-a48a-ea2c5b31745d','490a8bcb-b35b-416d-bd95-73bf3d89ffff', 'vn', 'Nhà bếp', 'cơ sở vật chất', false),
       ('490a8bcb-b35b-416d-bd95-73bf3d89ffff','4755b305-f9b1-4c44-a48a-ea2c5b31745d', 'en', 'kitchen', 'infrastructure', false),
       ('b8f2099d-b99f-4186-9be7-ec57834104c3','dd117b12-3186-4225-bd5d-93b4f2627690', 'vn', 'xông hơi', 'dịch vụ', false),
       ('dd117b12-3186-4225-bd5d-93b4f2627690', 'b8f2099d-b99f-4186-9be7-ec57834104c3', 'en', 'sauna', 'service', false);

INSERT INTO hotel (hotel_id, name_hotel)
VALUES ('6ef87b11-fc41-49fa-8f55-bb046cf776c4', 'Hotel1'),
       ('99884772-a0c7-482a-bd67-cabf4c8d8152', 'Hotel2');