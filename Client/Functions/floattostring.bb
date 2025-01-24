Function floattostring$(arg0#, arg1%)
    Return left((Str arg0), ((len((Str (Int arg0))) + arg1) + $01))
    Return ""
End Function
