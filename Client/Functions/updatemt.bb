Function updatemt%(arg0.mtgrid, arg1%)
    Local local0%
    Local local1%
    catcherrors("UpdateMT()")
    For local0 = $00 To $12 Step $01
        For local1 = $00 To $12 Step $01
            If (arg0\Field3[((local1 * $13) + local0)] <> $00) Then
                If ((((fog\Field0 * lightvolume) * 1.3) * ((fog\Field0 * lightvolume) * 1.3)) > distancesquared(entityx(arg1, $01), entityx(arg0\Field3[((local1 * $13) + local0)], $01), entityz(arg1, $01), entityz(arg0\Field3[((local1 * $13) + local0)], $01), 0.0, 0.0)) Then
                    If (entityhidden(arg0\Field3[((local1 * $13) + local0)]) <> 0) Then
                        showentity(arg0\Field3[((local1 * $13) + local0)])
                    EndIf
                ElseIf (entityhidden(arg0\Field3[((local1 * $13) + local0)]) = $00) Then
                    hideentity(arg0\Field3[((local1 * $13) + local0)])
                EndIf
            EndIf
        Next
    Next
    catcherrors("Uncaught: UpdateMT()")
    Return $00
End Function
