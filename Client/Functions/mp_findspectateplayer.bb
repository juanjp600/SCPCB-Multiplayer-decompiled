Function mp_findspectateplayer.mp_player(arg0.mp_player, arg1%)
    If (((arg1 = $FFFFFFFF) Lor (arg0 = Null)) <> 0) Then
        arg0 = (First mp_player)
        Return arg0
    EndIf
    While (((arg0 <> Null) And entityhidden(arg0\Field18)) <> 0)
        If (arg1 <> 0) Then
            arg0 = (After arg0)
        Else
            arg0 = (Before arg0)
        EndIf
    Wend
    If (arg0 = Null) Then
        If (arg1 <> 0) Then
            arg0 = (First mp_player)
        Else
            arg0 = (Last mp_player)
        EndIf
    EndIf
    Return arg0
    Return Null
End Function
