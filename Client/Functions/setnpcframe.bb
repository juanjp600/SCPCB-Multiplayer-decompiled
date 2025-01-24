Function setnpcframe%(arg0.npcs, arg1#)
    If (0.001 > (Abs (arg0\Field14 - arg1))) Then
        Return $00
    EndIf
    If ((hidedistance * hidedistance) <= entitydistancesquared(arg0\Field3, me\Field60)) Then
        If (0.0 >= arg0\Field16) Then
            setanimtime(arg0\Field0, arg1, $00)
            arg0\Field16 = (fps\Field7[$00] * 4.0)
        Else
            arg0\Field16 = (arg0\Field16 - fps\Field7[$00])
        EndIf
    Else
        setanimtime(arg0\Field0, arg1, $00)
    EndIf
    arg0\Field14 = arg1
    Return $00
End Function
