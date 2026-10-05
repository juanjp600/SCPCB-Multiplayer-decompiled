Function playerinreachableroom%(arg0%, arg1%)
    Local local0$
    Local local1%
    Local local2%
    local0 = playerroom\Field8\Field11
    Select local0
        Case "pocketdimension","gatea","dimension1499","173"
            Return $00
    End Select
    If (((local0 = "exit1") And (4.0625 < entityy(collider, $00))) <> 0) Then
        Return $00
    EndIf
    local2 = $00
    If (room860event <> Null) Then
        If (1.0 = room860event\Field2) Then
            local2 = $01
        EndIf
    EndIf
    If (((local0 = "room860") And local2) <> 0) Then
        Return $00
    EndIf
    If (arg1 = $00) Then
        If (arg0 = $00) Then
            If (selecteddifficulty\Field3 = $00) Then
                If (((local0 = "room049") And (-11.125 >= entityy(collider, $00))) <> 0) Then
                    Return $00
                EndIf
            EndIf
        EndIf
    EndIf
    Return $01
    Return $00
End Function
