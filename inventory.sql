/*
SQLyog Community v9.63 
MySQL - 5.5.5-10.1.21-MariaDB : Database - db_inventory_pos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_inventory_pos` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_inventory_pos`;

/*Table structure for table `tb_filateli` */

DROP TABLE IF EXISTS `tb_filateli`;

CREATE TABLE `tb_filateli` (
  `id_filateli` varchar(7) NOT NULL,
  `nama_filateli` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  PRIMARY KEY (`id_filateli`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_filateli` */

/*Table structure for table `tb_jenis_kantor` */

DROP TABLE IF EXISTS `tb_jenis_kantor`;

CREATE TABLE `tb_jenis_kantor` (
  `id_jenis` varchar(5) NOT NULL,
  `jenis_kantor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_jenis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_jenis_kantor` */

/*Table structure for table `tb_jenis_produk` */

DROP TABLE IF EXISTS `tb_jenis_produk`;

CREATE TABLE `tb_jenis_produk` (
  `id_jenis_produk` varchar(5) NOT NULL,
  `nama_jenis_produk` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_jenis_produk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_jenis_produk` */

/*Table structure for table `tb_kantor_cabang` */

DROP TABLE IF EXISTS `tb_kantor_cabang`;

CREATE TABLE `tb_kantor_cabang` (
  `id_kantor` varchar(9) NOT NULL,
  `nama_kantor` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_telp` varchar(13) DEFAULT NULL,
  `kode_pos` int(11) DEFAULT NULL,
  `id_jenis` varchar(5) DEFAULT NULL,
  `id_regional` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_kantor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_kantor_cabang` */

/*Table structure for table `tb_kemasan` */

DROP TABLE IF EXISTS `tb_kemasan`;

CREATE TABLE `tb_kemasan` (
  `id_kemasan` varchar(7) NOT NULL,
  `nama_kemasan` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  PRIMARY KEY (`id_kemasan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_kemasan` */

/*Table structure for table `tb_merchandise` */

DROP TABLE IF EXISTS `tb_merchandise`;

CREATE TABLE `tb_merchandise` (
  `id_merchandise` varchar(7) NOT NULL,
  `nama_merchandise` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  PRIMARY KEY (`id_merchandise`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_merchandise` */

/*Table structure for table `tb_ms&ss` */

DROP TABLE IF EXISTS `tb_ms&ss`;

CREATE TABLE `tb_ms&ss` (
  `id_ms&ss` varchar(7) NOT NULL,
  `nama_ms&ss` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  PRIMARY KEY (`id_ms&ss`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_ms&ss` */

/*Table structure for table `tb_prangko` */

DROP TABLE IF EXISTS `tb_prangko`;

CREATE TABLE `tb_prangko` (
  `id_prangko` varchar(7) NOT NULL,
  `nama_prangko` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  PRIMARY KEY (`id_prangko`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_prangko` */

/*Table structure for table `tb_prisma` */

DROP TABLE IF EXISTS `tb_prisma`;

CREATE TABLE `tb_prisma` (
  `id_prisma` varchar(7) NOT NULL,
  `nama_prisma` varchar(100) DEFAULT NULL,
  `nominal` bigint(20) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` bigint(20) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  PRIMARY KEY (`id_prisma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_prisma` */

/*Table structure for table `tb_regional` */

DROP TABLE IF EXISTS `tb_regional`;

CREATE TABLE `tb_regional` (
  `id_regional` varchar(5) NOT NULL,
  `regional` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_regional`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_regional` */

/*Table structure for table `tb_shp` */

DROP TABLE IF EXISTS `tb_shp`;

CREATE TABLE `tb_shp` (
  `id_shp` varchar(7) NOT NULL,
  `nama_shp` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  PRIMARY KEY (`id_shp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_shp` */

/*Table structure for table `tb_suplier` */

DROP TABLE IF EXISTS `tb_suplier`;

CREATE TABLE `tb_suplier` (
  `id_suplier` varchar(5) NOT NULL,
  `nama_suplier` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_suplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_suplier` */

/*Table structure for table `tb_trans_penerimaan` */

DROP TABLE IF EXISTS `tb_trans_penerimaan`;

CREATE TABLE `tb_trans_penerimaan` (
  `id_penerimaan` varchar(10) NOT NULL,
  `id_filateli` varchar(7) DEFAULT NULL,
  `id_kemasan` varchar(7) DEFAULT NULL,
  `id_merchandise` varchar(7) DEFAULT NULL,
  `id_ms&ss` varchar(7) DEFAULT NULL,
  `id_prangko` varchar(7) DEFAULT NULL,
  `id_prisma` varchar(7) DEFAULT NULL,
  `tgl_penerimaan` date DEFAULT NULL,
  `jml_terima` int(11) DEFAULT NULL,
  `id_produk` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id_penerimaan`),
  KEY `fk_2` (`id_filateli`),
  CONSTRAINT `fk_1` FOREIGN KEY (`id_filateli`) REFERENCES `tb_filateli` (`id_filateli`),
  CONSTRAINT `fk_2` FOREIGN KEY (`id_filateli`) REFERENCES `tb_kemasan` (`id_kemasan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_trans_penerimaan` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `nama_user` varchar(50) DEFAULT NULL,
  `nik` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
