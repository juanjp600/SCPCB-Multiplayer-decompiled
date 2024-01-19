Function updateforest%(arg0.forest, arg1%, arg2%)
    Local local0%
    Local local1%
    Local local2%
    local2 = $00
    If (12.0 > (Abs (entityy(arg1, $01) - entityy(arg0\Field4, $01)))) Then
        For local0 = $00 To $09 Step $01
            For local1 = $00 To $09 Step $01
                If (arg0\Field3[((local1 * $0A) + local0)] <> $00) Then
                    If (20.0 > (Abs (entityx(arg1, $01) - entityx(arg0\Field3[((local1 * $0A) + local0)], $01)))) Then
                        If (20.0 > (Abs (entityz(arg1, $01) - entityz(arg0\Field3[((local1 * $0A) + local0)], $01)))) Then
                            showentity(arg0\Field3[((local1 * $0A) + local0)])
                            showentity(arg0\Field4)
                            local2 = $01
                        Else
                            hideentity(arg0\Field3[((local1 * $0A) + local0)])
                        EndIf
                    Else
                        hideentity(arg0\Field3[((local1 * $0A) + local0)])
                    EndIf
                EndIf
            Next
        Next
    Else
        For local0 = $00 To $09 Step $01
            For local1 = $00 To $09 Step $01
                If (arg0\Field3[((local1 * $0A) + local0)] <> $00) Then
                    hideentity(arg0\Field3[((local1 * $0A) + local0)])
                EndIf
            Next
        Next
    EndIf
    Return local2
    Return $00
End Function
