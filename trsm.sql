-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 09 Şub 2024, 18:14:40
-- Sunucu sürümü: 8.0.31
-- PHP Sürümü: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `trsm`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_featuretype`
--

CREATE TABLE `tbl_featuretype` (
  `id` int NOT NULL,
  `feature_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `tbl_featuretype`
--

INSERT INTO `tbl_featuretype` (`id`, `feature_name`) VALUES
(1, 'Ücretsiz Otopark'),
(2, '7/24 Oda Servisi'),
(3, 'Fitness Center'),
(4, 'SPA'),
(5, 'Ücretsiz WiFi'),
(6, 'Yüzme havuzu'),
(7, 'Hotel Concierge');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_hotel`
--

CREATE TABLE `tbl_hotel` (
  `hotel_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `city` varchar(150) NOT NULL,
  `region` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `stars` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `tbl_hotel`
--

INSERT INTO `tbl_hotel` (`hotel_id`, `name`, `city`, `region`, `address`, `email`, `phoneNumber`, `stars`) VALUES
(1, 'Marmara Hotel', 'İstanbul', 'Taksim', 'Beyoğlu, İstanbul', 'marmara@gmail', '02125058085', 3),
(2, 'Hilton Hotel', 'İstanbul', 'Şişli', 'Harbiye, Cumhuriyet Cd. No:50, 34367 Şişli/İstanbul', 'hilton@gmail.com', '02123406780', 4),
(3, 'kapadokya', 'nevşehir', 'kapadokya', 'Ortahisar/Kapadokya/Nevşehir', 'kapadokya@gmail.com', '021678', 4),
(4, 'Swissotel', 'İzmir', 'Alsancak, Konak, İzmir', 'Konak', 'swissotel@gmail.com', '02325056070', 3),
(5, 'Divan Hotel', 'Ankara ', 'Çankaya', ' Yıldızevler, Jose Marti Cd. No:2, 06550 Çankaya/Ankara', 'divan@hotmail.com', '03124093000', 5),
(9, 'Otel Seyhan', 'Adana', 'Seyhan', 'Seyhan, Turhan Cemal Beriker Blv. Otel Seyhan 20/A, 01120', ' fitness@otelseyhan.com.tr', ' 4553030', 4),
(12, 'Edis Premier Hotel', 'Adana', 'Çukurova', ' Zahit Akdağ Blv. No:2, 01360 Çukurova/Adana', 'premier@hotmail.com', ' 0322290', 3),
(13, 'Anemon Hotel', 'Ankara', 'Çankaya', 'Kavaklıdere, Konur Sok. No:60, 06680 Çankaya/Ankara', 'anemon@hotmail.com', '03129502160', 3),
(14, 'Sürmeli Hotels', 'Adana', 'Seyhan', 'Beriker Blv. Otel Seyhan 20/A, 01120', ' hotel@sürmeli.com.tr', ' 4553030', 4),
(15, 'Vinifera Vineyards Hotel', 'İzmir', 'Selçuk', 'Yedi Bilgeler, 35920 Selçuk/İzmir', 'vinifre@hotmail.com', '894 82 57', 5),
(16, 'Hilton Hotel', 'İzmir', 'Konak', 'İsmet Kaptan, Gazi Osman Paşa Blv. No:7, 35210 Konak/İzmir', 'izmirhilton@hotmail.com', '50687', 5),
(17, 'hilton', 'kayseri', 'melikgazi', 'alpaslan mah kayseri', 'hilton@gmail', '789', 3),
(21, 'xdd', 'xxx', 'aas', 'xx', 'oo', 'ccc', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_hotel_feature`
--

CREATE TABLE `tbl_hotel_feature` (
  `hotel_id` int NOT NULL,
  `feature_id` int NOT NULL,
  `feature_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `tbl_hotel_feature`
--

INSERT INTO `tbl_hotel_feature` (`hotel_id`, `feature_id`, `feature_name`) VALUES
(1, 5, 'Ücretsiz WİFİ'),
(9, 7, 'Hotel Concierge'),
(9, 7, 'Hotel Concierge'),
(1, 1, 'Ücretsiz Otopark'),
(2, 2, '7/24 Oda Servisi'),
(3, 5, 'Ücretsiz WiFi'),
(4, 1, 'Ücretsiz Otopark'),
(5, 4, 'Fitness Center'),
(12, 2, '7/24 Oda Servisi'),
(9, 8, 'Yüzme Havuzu'),
(13, 1, 'Ücretsiz Otopark'),
(14, 5, 'Ücretsiz WiFi'),
(15, 4, 'Fitness Center'),
(16, 1, 'Ücretsiz Otopark'),
(16, 8, 'Yüzme Havuzu'),
(12, 7, 'Hotel Concierge'),
(1, 6, 'Yüzme havuzu'),
(1, 4, 'SPA'),
(9, 5, 'Ücretsiz WiFi'),
(17, 3, 'Fitness Center'),
(17, 6, 'Yüzme havuzu'),
(3, 5, 'Ücretsiz WiFi'),
(1, 7, 'Hotel Concierge'),
(16, 5, 'Ücretsiz WiFi'),
(9, 6, 'Yüzme havuzu');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_hotel_pension`
--

CREATE TABLE `tbl_hotel_pension` (
  `id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `pension_id` int NOT NULL,
  `pension_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `tbl_hotel_pension`
--

INSERT INTO `tbl_hotel_pension` (`id`, `hotel_id`, `pension_id`, `pension_name`) VALUES
(1, 1, 1, 'Ultra Herşey Dahil'),
(6, 9, 5, 'Alkol Hariç Full credit'),
(7, 12, 1, 'Ultra Herşey Dahil'),
(8, 13, 2, 'Tam Pansiyon'),
(9, 1, 6, 'Herşey Dahil'),
(10, 15, 2, 'Tam Pansiyon'),
(11, 16, 7, 'Oda Kahvaltı');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_hotel_room`
--

CREATE TABLE `tbl_hotel_room` (
  `room_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `season_id` int NOT NULL,
  `pension_id` int NOT NULL,
  `room_type` varchar(150) NOT NULL,
  `bed_number` int NOT NULL,
  `stock` int NOT NULL,
  `price_child` int NOT NULL,
  `price_adult` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `tbl_hotel_room`
--

INSERT INTO `tbl_hotel_room` (`room_id`, `hotel_id`, `season_id`, `pension_id`, `room_type`, `bed_number`, `stock`, `price_child`, `price_adult`) VALUES
(1, 1, 1, 1, 'Single', 70, 198, 200, 300),
(2, 1, 10, 2, 'Double', 10, 100, 200, 500),
(3, 9, 13, 3, 'King', 2, 3, 700, 900),
(16, 15, 14, 2, 'single', 3, 5, 400, 900),
(17, 1, 15, 6, 'king', 4, 5, 600, 800),
(18, 9, 16, 5, 'junior', 3, 5, 700, 1000),
(19, 1, 1, 1, 'junior king', 3, 6, 500, 600),
(20, 9, 16, 5, 'single', 2, 5, 700, 900),
(21, 9, 16, 5, 'double', 2, 3, 400, 600);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_pensiontype`
--

CREATE TABLE `tbl_pensiontype` (
  `id` int NOT NULL,
  `pension_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_reservation`
--

CREATE TABLE `tbl_reservation` (
  `reservation_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `room_id` int NOT NULL,
  `customer_name` varchar(150) NOT NULL,
  `customer_tc` varchar(150) NOT NULL,
  `customer_phone` varchar(150) NOT NULL,
  `customer_email` varchar(150) NOT NULL,
  `child_number` int NOT NULL,
  `adult_number` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `tbl_reservation`
--

INSERT INTO `tbl_reservation` (`reservation_id`, `hotel_id`, `room_id`, `customer_name`, `customer_tc`, `customer_phone`, `customer_email`, `child_number`, `adult_number`) VALUES
(10, 1, 1, 'ülkü', '3437', '908', 'ülkü@gmail', 1, 2),
(11, 1, 1, 'ülkü', '456', '0987', 'ülkü@gmail', 2, 2),
(12, 9, 3, 'ülkü', '64644', '888338', 'hsggsgs', 0, 2),
(13, 9, 3, 'kaan', '63636', '039383', 'kaan@hotmail', 0, 1),
(18, 9, 18, 'ömer', '28838', '93993', 'ömer@gmail', 2, 1),
(20, 9, 3, 'ali', '344', '345', 'ggh', 1, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_room_property`
--

CREATE TABLE `tbl_room_property` (
  `room_id` int NOT NULL,
  `property_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `tbl_room_property`
--

INSERT INTO `tbl_room_property` (`room_id`, `property_name`) VALUES
(1, 'Televizyon'),
(2, 'Minibar'),
(3, 'Kasa'),
(4, 'Ücretsiz Wifi'),
(5, 'Wifi'),
(6, 'Oyun Konsolu'),
(7, 'Projeksiyon'),
(20, 'televizyon');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_season`
--

CREATE TABLE `tbl_season` (
  `season_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `season_name` varchar(150) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `tbl_season`
--

INSERT INTO `tbl_season` (`season_id`, `hotel_id`, `season_name`, `start_date`, `end_date`) VALUES
(1, 1, 'Kış Sezonu', '2024-01-01', '2024-05-31'),
(10, 2, 'Yaz sezonu', '2024-05-01', '2024-09-01'),
(11, 3, 'Yaz sezonu', '2024-05-01', '2024-09-01'),
(12, 4, 'Kış Sezonu', '2024-01-01', '2024-05-31'),
(13, 5, 'Kış Sezonu', '2024-01-01', '2024-05-31'),
(14, 15, '1', '2024-02-01', '2024-03-01'),
(15, 1, 'Yaz sezonu', '2024-06-06', '2024-09-06'),
(16, 9, 'kış sezonu', '2024-01-01', '2024-09-09'),
(17, 17, 'Yaz Sezonu', '2024-06-01', '2024-09-01'),
(18, 3, 'Kış sezonu', '2024-01-01', '2024-06-01'),
(19, 16, 'kış sezonu', '2024-01-01', '2024-05-01'),
(20, 9, 'yaz sezonu', '2024-06-01', '2024-09-01');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int NOT NULL,
  `tcNo` varchar(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `usertype` enum('admin','employee','user') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Tablo döküm verisi `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `tcNo`, `username`, `password`, `name`, `surname`, `usertype`) VALUES
(1, '3578', 'ülkü', '11', 'ülkü', 'ülkü', 'admin'),
(2, '4555', 'karen', '357', 'karen', 'sahin', 'employee'),
(3, '7868', 'melek', '3434', 'melek', 'kara', 'employee'),
(4, '0978', 'ömer', '787', 'ömer', 'köker', 'admin'),
(5, '2353', 'kaan', '123', 'kaan', 'sahin', 'employee'),
(8, '222', 'ayşe', '678', 'ayşe', 'ak', 'employee'),
(9, '359', 'sarah', '09', 'sarah', 'sarah', 'employee'),
(10, '3456', 'ilayda', '890', 'ilayd', 'yılmaz', 'employee');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `tbl_featuretype`
--
ALTER TABLE `tbl_featuretype`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tbl_hotel`
--
ALTER TABLE `tbl_hotel`
  ADD PRIMARY KEY (`hotel_id`);

--
-- Tablo için indeksler `tbl_hotel_pension`
--
ALTER TABLE `tbl_hotel_pension`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tbl_hotel_room`
--
ALTER TABLE `tbl_hotel_room`
  ADD PRIMARY KEY (`room_id`);

--
-- Tablo için indeksler `tbl_pensiontype`
--
ALTER TABLE `tbl_pensiontype`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tbl_reservation`
--
ALTER TABLE `tbl_reservation`
  ADD PRIMARY KEY (`reservation_id`);

--
-- Tablo için indeksler `tbl_season`
--
ALTER TABLE `tbl_season`
  ADD PRIMARY KEY (`season_id`);

--
-- Tablo için indeksler `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `tbl_featuretype`
--
ALTER TABLE `tbl_featuretype`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_hotel`
--
ALTER TABLE `tbl_hotel`
  MODIFY `hotel_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_hotel_pension`
--
ALTER TABLE `tbl_hotel_pension`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_hotel_room`
--
ALTER TABLE `tbl_hotel_room`
  MODIFY `room_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_pensiontype`
--
ALTER TABLE `tbl_pensiontype`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_reservation`
--
ALTER TABLE `tbl_reservation`
  MODIFY `reservation_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_season`
--
ALTER TABLE `tbl_season`
  MODIFY `season_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
