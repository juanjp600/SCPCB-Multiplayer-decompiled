Function updatesavestate%()
    If (selecteddifficulty\Field3 <> $03) Then
        cansave = $03
        If ((((quickloadpercent > $FFFFFFFF) Lor (0.0 > me\Field3)) Lor (me\Field9 = $00)) <> 0) Then
            cansave = $00
        EndIf
    EndIf
    Return $00
End Function
