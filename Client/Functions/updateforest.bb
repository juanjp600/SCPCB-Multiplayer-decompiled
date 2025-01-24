Function updateforest%(arg0.forest)
    Local local0%
    Local local1%
    catcherrors("UpdateForest()")
    For local0 = $00 To $09 Step $01
        For local1 = $00 To $09 Step $01
            If (arg0\Field3[((local1 * $0A) + local0)] <> $00) Then
                If ((hidedistance * hidedistance) > distancesquared(entityx(me\Field60, $01), entityx(arg0\Field3[((local1 * $0A) + local0)], $01), entityz(me\Field60, $01), entityz(arg0\Field3[((local1 * $0A) + local0)], $01), 0.0, 0.0)) Then
                    If (entityhidden(arg0\Field3[((local1 * $0A) + local0)]) <> 0) Then
                        showentity(arg0\Field3[((local1 * $0A) + local0)])
                    EndIf
                ElseIf (entityhidden(arg0\Field3[((local1 * $0A) + local0)]) = $00) Then
                    hideentity(arg0\Field3[((local1 * $0A) + local0)])
                EndIf
            EndIf
        Next
    Next
    catcherrors("Uncaught: UpdateForest()")
    Return $00
End Function
