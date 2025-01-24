Function mp_playertakeitem%(arg0.mp_player, arg1.items)
    Local local0%
    If (arg0\Field3 >= maxitemamount) Then
        Return $00
    EndIf
    arg0\Field3 = (arg0\Field3 + $01)
    arg1\Field27 = arg0\Field5
    arg1\Field15 = $01
    arg1\Field16 = $FFFFFFFF
    hideentity(arg1\Field2)
    For local0 = $00 To (arg1\Field20 - $01) Step $01
        If (arg1\Field18[local0] <> Null) Then
            arg1\Field18[local0]\Field27 = arg0\Field5
        EndIf
    Next
    Return $00
End Function
