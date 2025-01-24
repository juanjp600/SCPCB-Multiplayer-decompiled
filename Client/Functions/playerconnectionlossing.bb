Function playerconnectionlossing%(arg0.mp_player)
    If (((arg0\Field14 <> $04) And (arg0\Field14 <> $01)) <> 0) Then
        If (((arg0\Field14 >= $04) And (arg0\Field14 <= $05)) <> 0) Then
            arg0\Field14 = $04
        Else
            arg0\Field14 = $01
        EndIf
    EndIf
    Return $00
End Function
