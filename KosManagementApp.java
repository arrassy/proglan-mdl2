import java.util.ArrayList;
import java.util.List;

/**
 * Kelas Room merepresentasikan sebuah kamar dengan nama dan harga sewa per hari.
 */
class Room {
    private String name;
    private double pricePerDay;

    /**
     * Konstruktor untuk membuat objek Room.
     *
     * @param name Nama kamar.
     * @param pricePerDay Harga sewa per hari.
     */
    public Room(String name, double pricePerDay) {
        setName(name);
        setPricePerDay(pricePerDay);
    }

    /**
     * Mengambil nama kamar.
     *
     * @return Nama kamar.
     */
    public String getName() {
        return name;
    }

    /**
     * Mengatur nama kamar.
     *
     * @param name Nama kamar yang baru.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mengambil harga sewa per hari.
     *
     * @return Harga sewa per hari.
     */
    public double getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Mengatur harga sewa per hari.
     *
     * @param pricePerDay Harga sewa per hari yang baru.
     * @throws IllegalArgumentException Jika harga per hari kurang dari nol.
     */
    public void setPricePerDay(double pricePerDay) {
        if (pricePerDay < 0) {
            throw new IllegalArgumentException("Harga per hari tidak boleh negatif");
        }
        this.pricePerDay = pricePerDay;
    }

    /**
     * Menghitung biaya sewa untuk jumlah hari tertentu.
     *
     * @param days Jumlah hari sewa.
     * @return Biaya sewa total.
     */
    public double calculateRent(int days) {
        return pricePerDay * days;
    }
}

/**
 * Kelas KosManagement mengelola daftar kamar dan menghitung biaya sewa.
 */
class KosManagement {
    private List<Room> roomList = new ArrayList<>();

    /**
     * Menambahkan kamar baru ke dalam daftar.
     *
     * @param name Nama kamar.
     * @param pricePerDay Harga sewa per hari.
     */
    public void addRoom(String name, double pricePerDay) {
        roomList.add(new Room(name, pricePerDay));
    }

    /**
     * Menghitung total biaya sewa untuk semua kamar selama jumlah hari tertentu.
     *
     * @param days Jumlah hari sewa.
     * @return Total biaya sewa.
     */
    public double calculateTotalRent(int days) {
        double totalRent = 0;
        for (Room room : roomList) {
            totalRent += room.calculateRent(days);
        }
        return totalRent;
    }

    /**
     * Mencetak laporan sewa kamar untuk jumlah hari tertentu.
     *
     * @param days Jumlah hari sewa.
     */
    public void printReport(int days) {
        System.out.println("----- Laporan Sewa Kamar Kos -----");
        for (Room room : roomList) {
            System.out.printf("Kamar: %s, Biaya Sewa: Rp%.2f%n", room.getName(), room.calculateRent(days));
        }
        System.out.printf("Total Biaya Sewa untuk %d hari: Rp%.2f%n", days, calculateTotalRent(days));
        System.out.println("------------------------------------");
    }

    /**
     * Menampilkan daftar semua kamar yang tersedia.
     */
    public void displayRooms() {
        System.out.println("Daftar Kamar:");
        for (Room room : roomList) {
            System.out.printf("Kamar: %s, Harga per Hari: Rp%.2f%n", room.getName(), room.getPricePerDay());
        }
    }
}

/**
 * Kelas KosManagementApp adalah titik masuk aplikasi untuk manajemen kos.
 */
public class KosManagementApp {
    /**
     * Metode utama untuk menjalankan aplikasi.
     *
     * @param args Argumen dari command line (tidak digunakan).
     */
    public static void main(String[] args) {
        KosManagement app = new KosManagement();
        app.addRoom("Kamar A", 50000);

        app.displayRooms();

        int days = 4;
        app.printReport(days);
    }
}
