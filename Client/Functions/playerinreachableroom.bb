Function playerinreachableroom%(arg0%)
    Local local0$
    Local local1%
    Local local2%
    local0 = playerroom\Field7\Field11
    If (((((local0 = "pocketdimension") Or (local0 = "gatea")) Or (local0 = "dimension1499")) Or (local0 = "173")) <> 0) Then
        Return $00
    EndIf
    If (((local0 = "exit1") And ((1040.0 * roomscale) < entityy(collider, $00))) <> 0) Then
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
    If (arg0 = $00) Then
        If (selecteddifficulty\Field3 = $00) Then
            If (((local0 = "room049") And ((-2848.0 * roomscale) >= entityy(collider, $00))) <> 0) Then
                Return $00
            EndIf
        EndIf
    EndIf
    Return $01
    Return $00
End Function
