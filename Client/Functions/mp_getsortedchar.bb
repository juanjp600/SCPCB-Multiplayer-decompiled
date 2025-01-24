Function mp_getsortedchar$(arg0%)
    If (serverlist\Field6[arg0] = $00) Then
        Return ""
    EndIf
    Return (" " + chr((((serverlist\Field6[arg0] - $01) Shl $01) + $3C)))
    Return ""
End Function
