public class PacketHandler {

    private Packet[] packets;       // stores all packages that need to be received
    private int size;               // amount of packages received already


    // Constructor
    public PacketHandler() {
        this.packets = null;
        this.size = 0;
    }

    /**
     * Processes a packet received from a sender by storing it,
     * if all expected packets have been received, the packets will be returned in the correct order by their ID.
     * If not all packets have been received, this method will return null.
     *
     * The packet handler will reset itself after returning the packets.
     *
     * @param p
     *     - the packet that needs to be processed
     * @return list of all packets in the correct order if all packets have been received, else null.
     */
    public Packet[] processPacket(Packet p) {
        if (this.packets == null) {                 // no package received yet
            packets = new Packet[p.getAmount()];
        }
        packets[p.getId()] = p;                     // id ordered
        size++;
        if (size < p.getAmount()) return null;
        // else return all packages in order
        Packet[] processed = packets;
        packets = null;                     // packet handler resets again
        size = 0;
        return processed;
    }

}
