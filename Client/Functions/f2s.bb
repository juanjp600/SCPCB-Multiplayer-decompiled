Function f2s$(arg0#, arg1%)
    Return left((Str arg0), ((len((Str (Int (Str arg0)))) + arg1) + $01))
    Return ""
End Function
