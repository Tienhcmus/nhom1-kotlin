package com.example.recyclerview.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.playing_fragment.*


class FragmentPlaying() : Fragment (){
var gridview = 0
    var listview = 0
    lateinit var mListner : DetailFragmentListener
    companion object {
        private val TAG = FragmentPlaying::class.java.simpleName
        const val JSON_ARRAY =
            "[{\"popularity\":195.72,\"vote_count\":2056,\"video\":false,\"poster_path\":\"\\/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg\",\"id\":338762,\"adult\":false,\"backdrop_path\":\"\\/ocUrMYbdjknu2TwzMHKT9PBBQRw.jpg\",\"original_language\":\"en\",\"original_title\":\"Bloodshot\",\"genre_ids\":[28,878],\"title\":\"Bloodshot\",\"vote_average\":7.1,\"overview\":\"After he and his wife are murdered, marine Ray Garrison is resurrected by a team of scientists. Enhanced with nanotechnology, he becomes a superhuman, biotech killing machine—'Bloodshot'. As Ray first trains with fellow super-soldiers, he cannot recall anything from his former life. But when his memories flood back and he remembers the man that killed both him and his wife, he breaks out of the facility to get revenge, only to discover that there's more to the conspiracy than he thought.\",\"release_date\":\"2020-03-05\"}," +
                    "{\"popularity\":186.038,\"vote_count\":3552,\"video\":false,\"poster_path\":\"\\/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg\",\"id\":454626,\"adult\":false,\"backdrop_path\":\"\\/1NNFH01APbTRj3xbxRM3xqM3OuN.jpg\",\"original_language\":\"en\",\"original_title\":\"Sonic the Hedgehog\",\"genre_ids\":[28,35,878,10751],\"title\":\"Sonic the Hedgehog\",\"vote_average\":7.6,\"overview\":\"Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.\",\"release_date\":\"2020-02-12\"}," +
                    "{\"popularity\":139.542,\"vote_count\":570,\"video\":false,\"poster_path\":\"\\/8ZMrZGGW65ePWIgRn1260nA1uUm.jpg\",\"id\":539537,\"adult\":false,\"backdrop_path\":\"\\/x80ZIVGUJ6plcUBcgVZ6DPKT7vc.jpg\",\"original_language\":\"en\",\"original_title\":\"Fantasy Island\",\"genre_ids\":[14,27,878],\"title\":\"Fantasy Island\",\"vote_average\":6,\"overview\":\"A group of contest winners arrive at an island hotel to live out their dreams, only to find themselves trapped in nightmare scenarios.\",\"release_date\":\"2020-02-12\"}," +
                    "{\"popularity\":129.243,\"vote_count\":1011,\"video\":false,\"poster_path\":\"\\/gzlbb3yeVISpQ3REd3Ga1scWGTU.jpg\",\"id\":443791,\"adult\":false,\"backdrop_path\":\"\\/ww7eC3BqSbFsyE5H5qMde8WkxJ2.jpg\",\"original_language\":\"en\",\"original_title\":\"Underwater\",\"genre_ids\":[28,27,878,53],\"title\":\"Underwater\",\"vote_average\":6.4,\"overview\":\"After an earthquake destroys their underwater station, six researchers must navigate two miles along the dangerous, unknown depths of the ocean floor to make it to safety in a race against time.\",\"release_date\":\"2020-01-08\"}," +
                    "{\"popularity\":166.974,\"vote_count\":776,\"video\":false,\"poster_path\":\"\\/33VdppGbeNxICrFUtW2WpGHvfYc.jpg\",\"id\":481848,\"adult\":false,\"backdrop_path\":\"\\/9sXHqZTet3Zg5tgcc0hCDo8Tn35.jpg\",\"original_language\":\"en\",\"original_title\":\"The Call of the Wild\",\"genre_ids\":[12,18,10751],\"title\":\"The Call of the Wild\",\"vote_average\":7.2,\"overview\":\"Buck is a big-hearted dog whose blissful domestic life is turned upside down when he is suddenly uprooted from his California home and transplanted to the exotic wilds of the Yukon during the Gold Rush of the 1890s. As the newest rookie on a mail delivery dog sled team—and later its leader—Buck experiences the adventure of a lifetime, ultimately finding his true place in the world and becoming his own master.\",\"release_date\":\"2020-02-19\"}," +
                    "{\"popularity\":109.689,\"vote_count\":6931,\"video\":false,\"poster_path\":\"\\/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg\",\"id\":496243,\"adult\":false,\"backdrop_path\":\"\\/TU9NIjwzjoKPwQHoHshkFcQUCG.jpg\",\"original_language\":\"ko\",\"original_title\":\"기생충\",\"genre_ids\":[35,18,53],\"title\":\"Parasite\",\"vote_average\":8.5,\"overview\":\"All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.\",\"release_date\":\"2019-05-30\"}," +
                    "{\"popularity\":86.634,\"vote_count\":11,\"video\":false,\"poster_path\":\"\\/7BC2Mv2ekyBIto68YOrc1DRARv6.jpg\",\"id\":597295,\"adult\":false,\"backdrop_path\":\"\\/hOREXWuVMG0xSKjdwh6QeOoJDFo.jpg\",\"original_language\":\"zh\",\"original_title\":\"我的青春都是你\",\"genre_ids\":[35,10749],\"title\":\"Love The Way You Are\",\"vote_average\":3.9,\"overview\":\"Opposites clash when spunky girl next door Lin Lin meets eccentric nerd Yuke. Despite being neighbors and schoolmates since childhood, Lin Lin and Yuke barely know each other. When the pair are both admitted into the same university, Lin Lin discovers that Yuke harbors a secret crush for campus beauty, Ruting. Ever the busybody, Lin Lin decides to matchmake Yuke and Ruting, only to find herself gradually falling for Yuke.\",\"release_date\":\"2019-06-21\"}," +
                    "{\"popularity\":84.281,\"vote_count\":1596,\"video\":false,\"poster_path\":\"\\/f4aul3FyD3jv3v4bul1IrkWZvzq.jpg\",\"id\":508439,\"adult\":false,\"backdrop_path\":\"\\/xFxk4vnirOtUxpOEWgA1MCRfy6J.jpg\",\"original_language\":\"en\",\"original_title\":\"Onward\",\"genre_ids\":[12,16,35,14,10751],\"title\":\"Onward\",\"vote_average\":7.9,\"overview\":\"In a suburban fantasy world, two teenage elf brothers embark on an extraordinary quest to discover if there is still a little magic left out there.\",\"release_date\":\"2020-02-29\"},{\"popularity\":59.939,\"vote_count\":52,\"video\":false,\"poster_path\":\"\\/v1DbnzXChoymNghOGAjFUZ9KYP1.jpg\",\"id\":430155,\"adult\":false,\"backdrop_path\":\"\\/oVLGuq431nF3f0yDi07q1gL4ehK.jpg\",\"original_language\":\"ru\",\"original_title\":\"Кома\",\"genre_ids\":[28,12,14,10749],\"title\":\"The Coma\",\"vote_average\":4.8,\"overview\":\"After a colossal and mysterious accident a young talented architect comes back to his senses in a very odd world that only resembles the reality. This world is based on the memories of the ones who live in it - people who are currently finding themselves in a deep coma. Human memory is spotty, chaotic and unstable. The same is the COMA - odd collection of memories and recollections - cities, glaciers and rivers can all be found in one room. All the laws of physics can be broken. The architect must find out the exact laws and regulations of COMA as he fights for his life, meets the love of his life and keeps on looking for the exit to the real world which he will have to get acquainted with all over again after the experience of COMA.\",\"release_date\":\"2019-11-19\"},{\"popularity\":50.791,\"vote_count\":1737,\"video\":false,\"poster_path\":\"\\/5EufsDwXdY2CVttYOk2WtYhgKpa.jpg\",\"id\":570670,\"adult\":false,\"backdrop_path\":\"\\/uZMZyvarQuXLRqf3xdpdMqzdtjb.jpg\",\"original_language\":\"en\",\"original_title\":\"The Invisible Man\",\"genre_ids\":[27,878,53],\"title\":\"The Invisible Man\",\"vote_average\":7.1,\"overview\":\"When Cecilia's abusive ex takes his own life and leaves her his fortune, she suspects his death was a hoax. As a series of coincidences turn lethal, Cecilia works to prove that she is being hunted by someone nobody can see.\",\"release_date\":\"2020-02-26\"},{\"popularity\":55.173,\"vote_count\":535,\"video\":false,\"poster_path\":\"\\/7W0G3YECgDAfnuiHG91r8WqgIOe.jpg\",\"id\":446893,\"adult\":false,\"backdrop_path\":\"\\/qsxhnirlp7y4Ae9bd11oYJSX59j.jpg\",\"original_language\":\"en\",\"original_title\":\"Trolls World Tour\",\"genre_ids\":[12,16,35,14,10402,10751],\"title\":\"Trolls World Tour\",\"vote_average\":7.6,\"overview\":\"Queen Poppy and Branch make a surprising discovery — there are other Troll worlds beyond their own, and their distinct differences create big clashes between these various tribes. When a mysterious threat puts all of the Trolls across the land in danger, Poppy, Branch, and their band of friends must embark on an epic quest to create harmony among the feuding Trolls to unite them against certain doom.\",\"release_date\":\"2020-03-12\"},{\"popularity\":53.179,\"vote_count\":27,\"video\":false,\"poster_path\":\"\\/zaecdNcjcVDiOcDcgQCOgHELSo0.jpg\",\"id\":605804,\"adult\":false,\"backdrop_path\":\"\\/A7xO8NpdS7fbBKGmh84HbSD21OJ.jpg\",\"original_language\":\"en\",\"original_title\":\"The Wretched\",\"genre_ids\":[27],\"title\":\"The Wretched\",\"vote_average\":6.7,\"overview\":\"A rebellious teenage boy embarks on a gutsy crusade to stop the terrifying evil he suspects has possessed his neighbor in this bone-chilling occult thriller.\",\"release_date\":\"2020-05-01\"},{\"popularity\":51.262,\"vote_count\":1408,\"video\":false,\"poster_path\":\"\\/xnjvwfDulnOCy8qtYX0iqydmMhk.jpg\",\"id\":448119,\"adult\":false,\"backdrop_path\":\"\\/xcUf6yIheo78btFqihlRLftdR3M.jpg\",\"original_language\":\"en\",\"original_title\":\"Dolittle\",\"genre_ids\":[12,35,14,10751],\"title\":\"Dolittle\",\"vote_average\":6.8,\"overview\":\"After losing his wife seven years earlier, the eccentric Dr. John Dolittle, famed doctor and veterinarian of Queen Victoria’s England, hermits himself away behind the high walls of Dolittle Manor with only his menagerie of exotic animals for company. But when the young queen falls gravely ill, a reluctant Dolittle is forced to set sail on an epic adventure to a mythical island in search of a cure, regaining his wit and courage as he crosses old adversaries and discovers wondrous creatures.\",\"release_date\":\"2020-01-01\"},{\"popularity\":50.64,\"id\":331482,\"video\":false,\"vote_count\":2026,\"vote_average\":7.9,\"title\":\"Little Women\",\"release_date\":\"2019-12-25\",\"original_language\":\"en\",\"original_title\":\"Little Women\",\"genre_ids\":[18,10749],\"backdrop_path\":\"\\/3uTxPIdVEXxHpsHOHdJC24QebBV.jpg\",\"adult\":false,\"overview\":\"Four sisters come of age in America in the aftermath of the Civil War.\",\"poster_path\":\"\\/yn5ihODtZ7ofn8pDYfxCmxh8AXI.jpg\"},{\"popularity\":49.889,\"vote_count\":302,\"video\":false,\"poster_path\":\"\\/dqA2FCzz4OMmXLitKopzf476RVB.jpg\",\"id\":585244,\"adult\":false,\"backdrop_path\":\"\\/ezcf15gSuZmW51N5yiqE3tWg9zu.jpg\",\"original_language\":\"en\",\"original_title\":\"I Still Believe\",\"genre_ids\":[18,10402],\"title\":\"I Still Believe\",\"vote_average\":7.8,\"overview\":\"The true-life story of Christian music star Jeremy Camp and his journey of love and loss that looks to prove there is always hope.\",\"release_date\":\"2020-03-12\"},{\"popularity\":49.814,\"vote_count\":202,\"video\":false,\"poster_path\":\"\\/n2C6jRK9PtPIs99RQhKtqGlsnsO.jpg\",\"id\":592834,\"adult\":false,\"backdrop_path\":\"\\/yalJdTsb6EcDX5devj2ltWXuceO.jpg\",\"original_language\":\"en\",\"original_title\":\"My Spy\",\"genre_ids\":[28,35,10751],\"title\":\"My Spy\",\"vote_average\":7,\"overview\":\"A hardened CIA operative finds himself at the mercy of a precocious 9-year-old girl, having been sent undercover to surveil her family.\",\"release_date\":\"2020-02-27\"},{\"popularity\":42.825,\"vote_count\":374,\"video\":false,\"poster_path\":\"\\/4w1ItwCJCTtSi9nPfJC1vU6NIVg.jpg\",\"id\":413518,\"adult\":false,\"backdrop_path\":\"\\/AdqOBPw4PdtzOcfEuQuZ8MNeTKb.jpg\",\"original_language\":\"it\",\"original_title\":\"Pinocchio\",\"genre_ids\":[14,10751],\"title\":\"Pinocchio\",\"vote_average\":7.1,\"overview\":\"Live-action adaptation of the classic story of a wooden puppet named Pinocchio who comes to life.\",\"release_date\":\"2019-12-19\"},{\"popularity\":42.049,\"vote_count\":595,\"video\":false,\"poster_path\":\"\\/rmflsMjk4lxx2foNUtd1OKWv6vB.jpg\",\"id\":514847,\"adult\":false,\"backdrop_path\":\"\\/qfQ78ZKiouoM2yhAnfNblp9ijQE.jpg\",\"original_language\":\"en\",\"original_title\":\"The Hunt\",\"genre_ids\":[28,27,53],\"title\":\"The Hunt\",\"vote_average\":6.8,\"overview\":\"Twelve strangers wake up in a clearing. They don't know where they are—or how they got there. In the shadow of a dark internet conspiracy theory, ruthless elitists gather at a remote location to hunt humans for sport. But their master plan is about to be derailed when one of the hunted turns the tables on her pursuers.\",\"release_date\":\"2020-03-11\"},{\"popularity\":41.205,\"vote_count\":541,\"video\":false,\"poster_path\":\"\\/2kNnf7BwRCEm4bcFkdiE0T4U25s.jpg\",\"id\":457335,\"adult\":false,\"backdrop_path\":\"\\/fssCO59bqU5f0zngeYKex0g1vyb.jpg\",\"original_language\":\"en\",\"original_title\":\"Guns Akimbo\",\"genre_ids\":[28,35],\"title\":\"Guns Akimbo\",\"vote_average\":6.3,\"overview\":\"An ordinary guy suddenly finds himself forced to fight a gladiator-like battle for a dark website that streams the violence for viewers. Miles must fight heavily armed Nix and also save his kidnapped ex-girlfriend.\",\"release_date\":\"2020-02-27\"},{\"popularity\":40.536,\"vote_count\":977,\"video\":false,\"poster_path\":\"\\/gbPfvwBqbiHpQkYZQvVwB6MVauV.jpg\",\"id\":525661,\"adult\":false,\"backdrop_path\":\"\\/nj84vpuUWdbmYktBzjiWn5Ny1ZF.jpg\",\"original_language\":\"en\",\"original_title\":\"Bombshell\",\"genre_ids\":[18],\"title\":\"Bombshell\",\"vote_average\":6.8,\"overview\":\"Bombshell is a revealing look inside the most powerful and controversial media empire of all time; and the explosive story of the women who brought down the infamous man who created it.\",\"release_date\":\"2019-12-13\"}]"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return   inflater.inflate(R.layout.playing_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MovieAdapter(context, covertJsontoList(), listener)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == R.id.listview)
        {
            rv.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = MovieAdapter(context, covertJsontoList(), listener)
            }
        }
        if(id == R.id.gridview)
        {
          rv.apply {
              layoutManager = GridLayoutManager(activity, 3, LinearLayoutManager.VERTICAL, false)
              adapter = MovieAdapter_Grid(context, covertJsontoList(), listener2)
          }
        }
        return super.onOptionsItemSelected(item)
    }
    private var listener = object : MovieAdapter.MovieListener {
        override fun onClick(pos: Int, movie: MovieModel) {
            startProfileActivity(movie)
        }

        override fun favrite(pos: Int, movies: MovieModel) {
            val builder = AlertDialog.Builder(activity)
                .setMessage("Bạn có muốn thêm vào danh sách phim yêu thích không?")
                .setPositiveButton("YES") { _, _ ->
                    //add to Favorite movie
                    addFavoritemoive(movies)

                }
                .setNegativeButton("NO") { dialog, _ -> dialog?.dismiss() }
            val dialog = builder.create();
            dialog.show()
        }
    }

        private var listener2 = object : MovieAdapter_Grid.MovieListener {
            override fun onClick(pos: Int, movie: MovieModel) {
                startProfileActivity(movie)
            }

            override fun favrite(pos: Int, movies: MovieModel) {
                val builder = AlertDialog.Builder(activity)
                    .setMessage("Bạn có muốn thêm vào danh sách phim yêu thích không?")
                    .setPositiveButton("YES") { _, _ ->
                        //add to Favorite movie
                        addFavoritemoive(movies)

                    }
                    .setNegativeButton("NO") { dialog, _ -> dialog?.dismiss() }
                val dialog = builder.create();
                dialog.show()
            }
        }



    fun covertJsontoList(): ArrayList<MovieModel> {
        val gson = Gson()
        val arrayTutorialType = object : TypeToken<ArrayList<MovieModel>>() {}.type
        var data: ArrayList<MovieModel> = gson.fromJson(FragmentPlaying.JSON_ARRAY, arrayTutorialType)
        return data
    }

    private fun addFavoritemoive(movie: MovieModel) {
        mListner.onDetailFragmentListener(movie)
    }
    private fun startProfileActivity(movie: MovieModel) {
        val intent = Intent (activity, MovieActivity2::class.java)
        intent.putExtra("title", movie.title)
        intent.putExtra("vote_average", movie.vote_average)
        intent.putExtra("release_date", movie.release_date)
        intent.putExtra("overview", movie.overview)
        intent.putExtra("poster_path", movie.getURL())
        activity?.startActivity(intent)
    }
    interface DetailFragmentListener{
        fun onDetailFragmentListener(movie: MovieModel)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is DetailFragmentListener) {
            mListner = context as DetailFragmentListener
        }
    }

}


