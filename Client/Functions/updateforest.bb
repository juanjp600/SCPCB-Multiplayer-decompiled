Function updateforest%(arg0.forest, arg1%, arg2%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8%
    Local local9#
    Local local10#
    Local local11.particles
    local3 = $00
    local4 = entityx(arg1, $01)
    local5 = entityy(arg1, $01)
    local6 = entityz(arg1, $01)
    local7 = entityy(arg0\Field4, $01)
    If (12.0 > (Abs (local5 - local7))) Then
        For local2 = $00 To $63 Step $01
            local8 = arg0\Field3[local2]
            If (local8 <> $00) Then
                local9 = (Abs (local4 - entityx(local8, $01)))
                local10 = (Abs (local6 - entityz(local8, $01)))
                If (((15.6 > local9) And (15.6 > local10)) <> 0) Then
                    showentity(local8)
                    If (particleamount > $01) Then
                        If (rand($01, $0A) = $01) Then
                            local11 = createparticle((rnd(-6.0, 6.0) + local4), (rnd(1.0, 2.0) + local5), (rnd(-6.0, 6.0) + local6), $0B, rnd(0.01, 0.03), rnd(0.02, 0.06), $12C, rnd(0.7, 0.9), $01)
                            local11\Field6 = rnd(-0.2, 0.02)
                            rotatesprite(local11\Field0, (Float rand($168, $01)))
                        EndIf
                    EndIf
                    local3 = $01
                Else
                    hideentity(local8)
                EndIf
            EndIf
        Next
        If (local3 <> 0) Then
            showentity(arg0\Field4)
        EndIf
    Else
        For local2 = $00 To $63 Step $01
            If (arg0\Field3[local2] <> $00) Then
                hideentity(arg0\Field3[local2])
            EndIf
        Next
    EndIf
    Return local3
    Return $00
End Function
