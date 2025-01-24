Function playerinreachableroom%(arg0%, arg1%)
    Local local0%
    If (((((playerroom\Field7\Field6 = $69) Lor (playerroom\Field7\Field6 = $6A)) Lor ((playerroom\Field7\Field6 = $04) And (arg1 = $00))) Lor isplayeroutsidefacility()) <> 0) Then
        Return $00
    EndIf
    If (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
        If (1.0 = forest_event\Field2) Then
            Return $00
        EndIf
    EndIf
    If (skull_event <> Null) Then
        If (0.0 < skull_event\Field2) Then
            Return $00
        EndIf
    EndIf
    If (arg0 = $00) Then
        If (selecteddifficulty\Field2 = $00) Then
            If (((playerroom\Field7\Field6 = $3A) And (infacility = $FFFFFFFF)) <> 0) Then
                Return $00
            EndIf
        EndIf
    EndIf
    Return $01
    Return $00
End Function
