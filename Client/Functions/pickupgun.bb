Function pickupgun%(arg0.items)
    If (multiplayer_isascp(myplayer\Field51) = $00) Then
        If (eqquipedgun = Null) Then
            holdinggun = isagun(arg0\Field3\Field2)
            If (holdinggun <> $00) Then
                eqquipedgun = getguntype(holdinggun)
                selecteditem = Null
            EndIf
        ElseIf (isagun(arg0\Field3\Field2) <> 0) Then
            If (isagun(arg0\Field3\Field2) = eqquipedgun\Field0) Then
                eqquipedgun = Null
                selecteditem = Null
            Else
                holdinggun = isagun(arg0\Field3\Field2)
                If (holdinggun <> $00) Then
                    eqquipedgun = getguntype(holdinggun)
                    selecteditem = Null
                EndIf
            EndIf
        EndIf
    EndIf
    Return $00
End Function
