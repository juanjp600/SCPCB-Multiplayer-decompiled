Function hideforest%(arg0.forest)
    Local local0%
    Local local1%
    For local0 = $00 To $09 Step $01
        For local1 = $00 To $09 Step $01
            If (arg0\Field3[((local1 * $0A) + local0)] <> $00) Then
                hideentity(arg0\Field3[((local1 * $0A) + local0)])
            EndIf
        Next
    Next
    Return $00
End Function
