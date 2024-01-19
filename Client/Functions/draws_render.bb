Function draws_render%()
    Local local0.draws
    Local local1.draws
    For local0 = Each draws
        If (local0\Field1 = $00) Then
            If (local0\Field2 = $00) Then
                For local1 = Each draws
                    If (local1\Field0 = local0\Field0) Then
                        If ((((local0\Field5 = local1\Field5) And (local0\Field6 = local1\Field6)) And (local1 <> local0)) <> 0) Then
                            local0\Field2 = local1\Field2
                            Exit
                        EndIf
                    EndIf
                Next
                If (local0\Field2 = $00) Then
                    local0\Field2 = loadimage(local0\Field0)
                    If (((local0\Field5 <> $FFFFFFFF) And (local0\Field2 <> $00)) <> 0) Then
                        resizeimage(local0\Field2, (Float local0\Field5), (Float local0\Field6))
                    EndIf
                EndIf
            EndIf
            If (local0\Field2 <> 0) Then
                drawblock(local0\Field2, local0\Field3, local0\Field4, $00)
            EndIf
        Else
            color(intcolor(local0\Field8, $10), intcolor(local0\Field8, $08), intcolor(local0\Field8, $00))
            Select local0\Field1
                Case $01
                    rect(local0\Field3, local0\Field4, local0\Field5, local0\Field6, $01)
                Case $02
                    oval(local0\Field3, local0\Field4, local0\Field5, local0\Field6, $01)
            End Select
        EndIf
    Next
    Return $00
End Function
