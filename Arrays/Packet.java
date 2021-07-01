import java.util.ArrayList;
import java.util.List;

class Packet {

    private int amount;

    private int id;

    private String msg;

    /**
     * Creates a new packet
     *
     * @param amount - the number of packets in total
     * @param id - the identifier (sequence number) of this packet
     * @param msg - the message (payload) of this packet
     */
    public Packet(int amount, int id, String msg) {
        this.amount = amount;
        this.id = id;
        this.msg = msg;
    }

    /**
     * @return Id (sequence number) of this packet
     */
    public int getId() {
        return this.id;
    }

    public int getAmount() {
        return this.amount;
    }

    /**
     * @return Message (payload) of this packet
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * @return String encoding of this packet
     */
    public String toString() {
        return this.id + ": " + this.msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Packet) {
            Packet other = (Packet) o;
            if (this.id == other.id) {
                if (this.msg.equals(other.msg)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }


    /**
     * Given a String message and an integer representing the size of each packet,
     * the message will be split into separate packets and returned as a list.
     *
     * If the message is not divisible by packetSize, additional zeros will be used to pad the message.
     *
     * @param msg
     * @param packetSize
     * @return
     */
    public static List<Packet> createPackets(String msg, int packetSize) {
        List<Packet> res = new ArrayList<>();
        int n = msg.length();
        int remainder = n % packetSize;
        for (int i = 0; i < packetSize - remainder; i++) {
            msg += "0";
        }
        int packets = n / packetSize + (remainder == 0 ? 0 : 1);
        for (int i = 0; i < packets; i++) {
            res.add(new Packet(packets, i, msg.substring(i * packetSize, i * packetSize + packetSize)));
        }
        return res;
    }
}