Function texts_render%()
    Local local0.multiplayer_texts
    Local local1.multiplayer_texts
    For local0 = Each multiplayer_texts
        If (local0\Field2 = $00) Then
            For local1 = Each multiplayer_texts
                If ((((local1\Field0 = local0\Field0) And (local0\Field1 = local1\Field1)) And (local0 <> local1)) <> 0) Then
                    local0\Field2 = local1\Field2
                    Exit
                EndIf
            Next
            If (local0\Field2 = $00) Then
                local0\Field2 = loadfont(local0\Field0, (Int (local0\Field1 * menuscale)), $01, $00, $00)
            EndIf
        EndIf
        If (local0\Field2 <> 0) Then
            setfont(local0\Field2)
            color(intcolor(local0\Field3, $10), intcolor(local0\Field3, $08), intcolor(local0\Field3, $00))
            text(local0\Field5, local0\Field6, local0\Field4, $00, $00)
        EndIf
    Next
    Return $00
End Function
