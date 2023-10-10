package com.example.kotlin.favoritemovie.framework.views.fragments

import androidx.fragment.app.Fragment

class MovieFragment: Fragment() {
    private var _binding: FragmentMovieBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    private lateinit var viewModel: MovieViewModel

    private lateinit var recyclerView: RecyclerView
    private val adapter: MovieAdapter = MovieAdapter()
    private lateinit var data: ArrayList<MovieBase>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        val root: View = binding.root

        data = ArrayList()

        initializeComponents(root)
        initializeObservers()
        viewModel.getMovieList()

        return root
    }
    )
}