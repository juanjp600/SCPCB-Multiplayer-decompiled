Function findeventobject%(arg0.events)
    Local local0%
    If (((arg0\Field21 >= server\Field11) Or ((arg0\Field14 + $01) = (server\Field18 + $01))) <> 0) Then
        arg0\Field14 = $00
        arg0\Field21 = $00
    EndIf
    For local0 = (arg0\Field14 + $01) To server\Field18 Step $01
        If (player[local0] <> Null) Then
            arg0\Field21 = (arg0\Field21 + $01)
            If (((player[local0]\Field32 = arg0\Field1\Field69) And (player[local0]\Field59 = $00)) <> 0) Then
                arg0\Field14 = local0
                Return player[arg0\Field14]\Field62
            EndIf
        EndIf
    Next
    arg0\Field14 = findplayer()
    Return player[arg0\Field14]\Field62
    Return $00
End Function
