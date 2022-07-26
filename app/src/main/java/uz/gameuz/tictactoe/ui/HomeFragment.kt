package uz.gameuz.tictactoe.ui

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.*
import uz.gameuz.tictactoe.model.Score
import uz.gameuz.tictactoe.databinding.CelebrateDialogBinding
import uz.gameuz.tictactoe.databinding.DrawDialogBinding
import uz.gameuz.tictactoe.databinding.FragmentHomeBinding
import uz.gameuz.tictactoe.extensions.hide
import uz.gameuz.tictactoe.extensions.show

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var score: ArrayList<Int>
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var reference: DatabaseReference

    var isFirstChange = true
    var position = true
    var first = false
    var firstPosition = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("arrayscores")
        score = ArrayList()
        initArray()
        //    enteranceFunction()
        initViews()
        return binding.root
    }

    private fun enteranceFunction() {
        reference.child("Score").get().addOnSuccessListener { snapshot ->
            val child = snapshot.getValue(Score::class.java)
            if (child!!.array != null) {
                score = child.array!!
            }

            position = child.position!!
            firstPosition = position
            controlShowAndHide()
            Log.d("@@@", snapshot.toString())
            Log.d("@@@", child.toString())
            Log.d("@@@", "fp: $firstPosition")
            Log.d("@@@", "pos: $position")
        }.addOnFailureListener {
            reference.child("Score").setValue(Score(true, score, false))
        }
    }

    private fun initArray() {
        score.add(2)
        score.add(3)
        score.add(4)
        score.add(5)
        score.add(6)
        score.add(7)
        score.add(8)
        score.add(9)
        score.add(10)
    }

    private fun initViews() {
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot.children

                for (child in children) {
                    val value = child.getValue(Score::class.java)
                    score = value!!.array!!
                    position = value!!.position!!
//                    if (first) {
//                        isFirstChange = true
//                        position = true
//                        firstPosition = true
//                        first = false
//                    }
                    if (value!!.win == true) {
                            openCelebrateDialog()

                    }
                    if (isEqual()){
                        openDrawDialog()
                    }
                    if (isFirstChange && !position) {
                        firstPosition = false
                        isFirstChange = false
                    }
                    Log.d("@@@", "add pos ${value!!.position!!} ")
                    Log.d("@@@", "isFirstChange ${isFirstChange} ")
                    controlShowAndHide()
                    Log.d("@@@", score.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        binding.apply {
            img1.setOnClickListener {
                reference.child("Score").child("position").get().addOnSuccessListener {
                    position = it.value as Boolean
                    Log.d("@@@", "pos: $position")
                    Log.d("@@@", "frspos: $firstPosition")
                }
                if (position == firstPosition) {
                    if (position) {
                        score[0] = 1
                        position = false
                    } else {
                        score[0] = 0
                        position = true
                    }
                    isFirstChange = false
                    controlShowAndHide()
                    reference.child("Score").setValue(Score(position, score, false))
                    isWin()
                    img1.isEnabled = false
                } else Toast.makeText(
                    requireContext(),
                    "Do'stingiz tanlashini kuting",
                    Toast.LENGTH_SHORT
                ).show()

            }
            img2.setOnClickListener {
                reference.child("Score").child("position").get().addOnSuccessListener {
                    position = it.value as Boolean
                    Log.d("@@@", "pos: $position")
                    Log.d("@@@", "frspos: $firstPosition")
                }
                if (position == firstPosition) {
                    if (position) {
                        score[1] = 1
                        position = false
                    } else {
                        score[1] = 0
                        position = true
                    }
                    isFirstChange = false
                    controlShowAndHide()
                    reference.child("Score").setValue(Score(position, score, false))
                    isWin()
                    img2.isEnabled = false
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Do'stingiz tanlashini kuting",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }
            img3.setOnClickListener {
                reference.child("Score").child("position").get().addOnSuccessListener {
                    position = it.value as Boolean
                    Log.d("@@@", "pos: $position")
                    Log.d("@@@", "frspos: $firstPosition")
                }
                if (position == firstPosition) {
                    if (position) {
                        score[2] = 1
                        position = false
                    } else {
                        score[2] = 0
                        position = true
                    }
                    isFirstChange = false
                    controlShowAndHide()
                    reference.child("Score").setValue(Score(position, score, false))
                    isWin()
                    img3.isEnabled = false
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Do'stingiz tanlashini kuting",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }
            img4.setOnClickListener {
                reference.child("Score").child("position").get().addOnSuccessListener {
                    position = it.value as Boolean
                    Log.d("@@@", "pos: $position")
                    Log.d("@@@", "frspos: $firstPosition")
                }
                if (position == firstPosition) {
                    if (position) {
                        score[3] = 1
                        position = false
                    } else {
                        score[3] = 0
                        position = true
                    }
                    isFirstChange = false
                    controlShowAndHide()
                    reference.child("Score").setValue(Score(position, score, false))
                    isWin()
                    img4.isEnabled = false
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Do'stingiz tanlashini kuting",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            img5.setOnClickListener {
                reference.child("Score").child("position").get().addOnSuccessListener {
                    position = it.value as Boolean
                    Log.d("@@@", "pos: $position")
                    Log.d("@@@", "frspos: $firstPosition")
                }
                if (position == firstPosition) {
                    if (position) {
                        score[4] = 1
                        position = false
                    } else {
                        score[4] = 0
                        position = true
                    }
                    isFirstChange = false
                    controlShowAndHide()
                    reference.child("Score").setValue(Score(position, score, false))
                    isWin()
                    img5.isEnabled = false
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Do'stingiz tanlashini kuting",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            img6.setOnClickListener {
                reference.child("Score").child("position").get().addOnSuccessListener {
                    position = it.value as Boolean
                    Log.d("@@@", "pos: $position")
                    Log.d("@@@", "frspos: $firstPosition")
                }
                if (position == firstPosition) {
                    if (position) {
                        score[5] = 1
                        position = false
                    } else {
                        score[5] = 0
                        position = true
                    }
                    isFirstChange = false
                    controlShowAndHide()
                    reference.child("Score").setValue(Score(position, score, false))
                    isWin()
                    img6.isEnabled = false
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Do'stingiz tanlashini kuting",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            img7.setOnClickListener {
                reference.child("Score").child("position").get().addOnSuccessListener {
                    position = it.value as Boolean
                    Log.d("@@@", "pos: $position")
                    Log.d("@@@", "frspos: $firstPosition")
                }
                if (position == firstPosition) {
                    if (position) {
                        score[6] = 1
                        position = false
                    } else {
                        score[6] = 0
                        position = true
                    }
                    isFirstChange = false
                    controlShowAndHide()
                    reference.child("Score").setValue(Score(position, score, false))
                    isWin()
                    img7.isEnabled = false
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Do'stingiz tanlashini kuting",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            img8.setOnClickListener {
                reference.child("Score").child("position").get().addOnSuccessListener {
                    position = it.value as Boolean
                    Log.d("@@@", "pos: $position")
                    Log.d("@@@", "frspos: $firstPosition")
                }
                if (position == firstPosition) {
                    if (position) {
                        score[7] = 1
                        position = false
                    } else {
                        score[7] = 0
                        position = true
                    }
                    isFirstChange = false
                    controlShowAndHide()
                    reference.child("Score").setValue(Score(position, score, false))
                    isWin()
                    img8.isEnabled = false
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Do'stingiz tanlashini kuting",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            img9.setOnClickListener {
                reference.child("Score").child("position").get().addOnSuccessListener {
                    position = it.value as Boolean
                    Log.d("@@@", "pos: $position")
                    Log.d("@@@", "frspos: $firstPosition")
                }
                if (position == firstPosition) {
                    if (position) {
                        score[8] = 1
                        position = false
                    } else {
                        score[8] = 0
                        position = true
                    }
                    isFirstChange = false
                    controlShowAndHide()
                    reference.child("Score").setValue(Score(position, score, false))
                    isWin()
                    img9.isEnabled = false
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Do'stingiz tanlashini kuting",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            Log.d("@@@", "position $position")
            binding.btnRefresh.setOnClickListener {
                setDefaultScores()
            }
        }

    }

    fun controlShowAndHide() {
        Log.d("@@@", "fp: $firstPosition")
        if (score[0] == 1) {
            binding.cross11.show()
        } else {
            binding.cross11.hide()
        }
        if (score[0] == 0) {
            binding.circle11.show()
        } else {
            binding.circle11.hide()
        }
        if (score[1] == 1) {
            binding.cross12.show()
        } else {
            binding.cross12.hide()
        }
        if (score[1] == 0) {
            binding.circle12.show()
        } else {
            binding.circle12.hide()
        }
        if (score[2] == 1) {
            binding.cross13.show()
        } else {
            binding.cross13.hide()
        }
        if (score[2] == 0) {
            binding.circle13.show()
        } else {
            binding.circle13.hide()
        }
        if (score[3] == 1) {
            binding.cross21.show()
        } else {
            binding.cross21.hide()
        }
        if (score[3] == 0) {
            binding.circle21.show()
        } else {
            binding.circle21.hide()
        }
        if (score[4] == 1) {
            binding.cross22.show()
        } else {
            binding.cross22.hide()
        }
        if (score[4] == 0) {
            binding.circle22.show()
        } else {
            binding.circle22.hide()
        }
        if (score[5] == 1) {
            binding.cross23.show()
        } else {
            binding.cross23.hide()
        }
        if (score[5] == 0) {
            binding.circle23.show()
        } else {
            binding.circle23.hide()
        }
        if (score[6] == 1) {
            binding.cross31.show()
        } else {
            binding.cross31.hide()
        }
        if (score[6] == 0) {
            binding.circle31.show()
        } else {
            binding.circle31.hide()
        }
        if (score[7] == 1) {
            binding.cross32.show()
        } else {
            binding.cross32.hide()
        }
        if (score[7] == 0) {
            binding.circle32.show()
        } else {
            binding.circle32.hide()
        }
        if (score[8] == 1) {
            binding.cross33.show()
        } else {
            binding.cross33.hide()
        }
        if (score[8] == 0) {
            binding.circle33.show()
        } else {
            binding.circle33.hide()
        }

    }

    fun isWin() {
        if (score[0] == score[1] && score[0] == score[2]) {
            isFirstChange = true
            position = true
            firstPosition = true
            reference.child("Score").setValue(Score(position, score, true))
        }
        if (score[3] == score[4] && score[3] == score[5]) {
            isFirstChange = true
            position = true
            firstPosition = true
            reference.child("Score").setValue(Score(position, score, true))

        }
        if (score[6] == score[7] && score[6] == score[8]) {
            isFirstChange = true
            position = true
            firstPosition = true
            reference.child("Score").setValue(Score(position, score, true))
        }

        if (score[0] == score[3] && score[0] == score[6]) {
            isFirstChange = true
            position = true
            firstPosition = true
            reference.child("Score").setValue(Score(position, score, true))
        }
        if (score[1] == score[4] && score[1] == score[7]) {
            isFirstChange = true
            position = true
            firstPosition = true
            reference.child("Score").setValue(Score(position, score, true))
        }
        if (score[2] == score[5] && score[2] == score[8]) {
            isFirstChange = true
            position = true
            firstPosition = true
            reference.child("Score").setValue(Score(position, score, true))
        }
        if (score[0] == score[4] && score[0] == score[8]) {
            isFirstChange = true
            position = true
            firstPosition = true
            reference.child("Score").setValue(Score(position, score, true))
        }
        if (score[2] == score[4] && score[2] == score[6]) {
            isFirstChange = true
            position = true
            firstPosition = true
            reference.child("Score").setValue(Score(position, score, true))
        }
    }

    fun setDefaultScores() {
        score.clear()
        initArray()
        first = true
        setButtonsEnabled()
        Log.d("@@@", "-----------------------------")
        reference.child("Score").setValue(Score(true, score, false))
        isFirstChange = true
        position = true
        firstPosition = true

    }

    fun setButtonsEnabled() {
        binding.apply {
            isFirstChange = true
            binding.img1.isEnabled = true
            binding.img2.isEnabled = true
            binding.img3.isEnabled = true
            binding.img4.isEnabled = true
            binding.img5.isEnabled = true
            binding.img6.isEnabled = true
            binding.img7.isEnabled = true
            binding.img8.isEnabled = true
            binding.img9.isEnabled = true
        }
    }

    fun openCelebrateDialog() {
        val dialog = Dialog(requireContext())
        val dialogLayout =
            CelebrateDialogBinding.inflate(LayoutInflater.from(requireContext()))
        dialog.setContentView(dialogLayout.root)
        dialog.apply {
            dialogLayout.winok.setOnClickListener {
                setDefaultScores()
                dialog.dismiss()
            }
        }
        dialog.show()
    }
    fun openDrawDialog() {
        val dialog = Dialog(requireContext())
        val dialogLayout =
            DrawDialogBinding.inflate(LayoutInflater.from(requireContext()))
        dialog.setContentView(dialogLayout.root)
        dialog.apply {
            dialogLayout.loseok.setOnClickListener {
                setDefaultScores()
                dialog.dismiss()
            }
        }
        dialog.show()
    }
    fun isEqual() : Boolean{
        for(i in score){
            if (i ==0 || i == 1){
                continue
            } else {
                return false
            }
        }
        return true
    }


}