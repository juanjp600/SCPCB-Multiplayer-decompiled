Function setnpcframe%(arg0.npcs, arg1#, arg2%)
    If (0.001 > (Abs (arg0\Field14 - arg1))) Then
        Return $00
    EndIf
    If ((hidedistance * hidedistance) <= entitydistancesquared(arg0\Field3, getrealcollider())) Then
        arg0\Field16 = (arg0\Field16 - fps\Field7[$00])
        If (0.0 >= arg0\Field16) Then
            setanimtime(arg0\Field0, arg1, $00)
            arg0\Field16 = (fps\Field7[$00] * 4.0)
        EndIf
    Else
        setanimtime(arg0\Field0, arg1, $00)
    EndIf
    If (arg2 <> 0) Then
        arg0\Field82 = arg1
    EndIf
    arg0\Field14 = arg1
    Return $00
End Function
