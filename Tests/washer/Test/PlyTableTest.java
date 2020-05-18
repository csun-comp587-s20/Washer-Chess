package washer.Test;

import org.junit.Test;
import org.mockito.Mock;
import washer.game.Ply;
import washer.game.PlyTable;
import washer.game.Side;
import washer.pieces.Bishop;
import washer.pieces.King;
import washer.pieces.Piece;

import java.util.*;

import static org.junit.Assert.*;

public class PlyTableTest {

    @Mock
    Ply ply;
    @Mock
    Side side;
    @Mock
    Piece piece;
    @Mock
    King king;
    @Mock
    Bishop bishop;

    public Map<Integer,Set<Ply>> generatePly(){
        Map<Integer, Set<Ply>> map = new HashMap<Integer, Set<Ply>>();
        Set<Ply> set = new HashSet<Ply>();
        set.add(ply);
        map.put(1,set);
        return map;
    }

    @Test
    public void test_getTable(){
        Map<Integer, Set<Ply>> map = new TreeMap<Integer, Set<Ply>>();
        Set<Ply> set = new HashSet<Ply>();
        set.add(ply);
        map.put(1,set);
        PlyTable plyTable = new PlyTable(generatePly());
        assertEquals(map,plyTable.getTable());
    }

    @Test
    public void test_getList() {
        List<Ply> list = new ArrayList<Ply>();
            list.add(ply);
        Map<Integer, Set<Ply>> map = new HashMap<Integer, Set<Ply>>();
        Set<Ply> set = new HashSet<Ply>();
            set.add(ply);
            map.put(1,set);
        PlyTable plyTable = new PlyTable(map);
        assertArrayEquals(list.toArray(),plyTable.getList().toArray());
    }

    @Test
    public void test_getKey(){
        Map<Integer, Set<Ply>> map = new HashMap<Integer, Set<Ply>>();
        Set<Ply> set = new HashSet<Ply>();
        set.add(ply);
        map.put(1,set);
        PlyTable plyTable = new PlyTable(map);
        assertEquals(set,plyTable.get(1));
    }

    @Test
    public void test_size0(){
        PlyTable plyTable = new PlyTable();
        assertEquals(0,plyTable.size());
    }

    @Test
    public void test_size_1(){
        PlyTable plyTable = new PlyTable(generatePly());
        assertEquals(1,plyTable.size());
    }

    @Test
    public void test_isEmpty(){
        PlyTable plyTable = new PlyTable(generatePly());
        assertFalse(plyTable.isEmpty());
    }

    @Test
    public void test_toString(){
        Map<Integer, Set<Ply>> map1 = new HashMap<Integer, Set<Ply>>();
        Map<Integer, Set<Ply>> map2 = new HashMap<Integer, Set<Ply>>();
        Set<Ply> set1 = new HashSet<Ply>();
        Set<Ply> set2 = new HashSet<Ply>();
        set1.add(ply);
        map1.put(1,set1);
        set2.add(ply);
        map2.put(1,set2);
        PlyTable plyTable1 = new PlyTable(map1);
        PlyTable plyTable2 = new PlyTable(map2);

        assertEquals(plyTable1.toString(),plyTable2.toString());
    }
}