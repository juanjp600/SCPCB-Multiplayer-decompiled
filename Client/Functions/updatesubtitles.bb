Function updatesubtitles%()
    Local local0.queuedsubtitlesmsg
    Local local1.subtitlesmsg
    Local local2%
    Local local3$
    Local local4%
    Local local5#
    Local local6$
    Local local7$
    Local local8#
    Local local9.subtitlesmsg
    Local local10#
    If (((selecteddifficulty\Field0 = difficulties[$03]\Field0) Lor (opt\Field25 = $00)) <> 0) Then
        Return $00
    EndIf
    local2 = (Int (10.0 * menuscale))
    For local0 = Each queuedsubtitlesmsg
        If (0.0 < local0\Field7) Then
            local0\Field7 = (local0\Field7 - fps\Field7[$00])
        Else
            local3 = local0\Field3
            local4 = $00
            local1 = (Last subtitlesmsg)
            While (len(local3) > $00)
                local5 = ((subassets\Field4 + (Float local2)) + (Float stringwidth(local3)))
                If (local5 > ((subassets\Field4 + subassets\Field3) - (Float local2))) Then
                    local6 = ""
                    While (local5 > ((subassets\Field4 + subassets\Field3) - (Float local2)))
                        local6 = (right(local3, $01) + local6)
                        local3 = left(local3, (Int max((Float (len(local3) - $01)), 0.0)))
                        local5 = ((subassets\Field4 + (Float local2)) + (Float stringwidth(local3)))
                    Wend
                    local7 = local3
                    While (right(local3, $01) <> " ")
                        local6 = (right(local3, $01) + local6)
                        local3 = left(local3, (Int max((Float (len(local3) - $01)), 0.0)))
                        local8 = ((subassets\Field4 + (Float local2)) + (Float stringwidth(local6)))
                        If (local8 > ((subassets\Field4 + subassets\Field3) - (Float local2))) Then
                            While (local8 > ((subassets\Field4 + subassets\Field3) - (Float local2)))
                                local3 = (right(local6, $01) + local3)
                                local6 = left(local6, (len(local6) - $01))
                                local8 = ((subassets\Field4 + (Float local2)) + (Float stringwidth(local6)))
                            Wend
                            Exit
                        EndIf
                        If (local3 = "") Then
                            local3 = local7
                            Exit
                        EndIf
                    Wend
                    If (local4 <> 0) Then
                        local1\Field2 = (local1\Field2 - (Float subassets\Field0))
                        local1\Field3 = (local1\Field3 - (Float subassets\Field0))
                        If ((Before local1) <> Null) Then
                            local1 = (Before local1)
                        EndIf
                    EndIf
                    createsubtitlesmsg(local0\Field0, local0\Field2, trim(local3), local0\Field8, local0\Field4, local0\Field5, local0\Field6)
                    local4 = $01
                    local3 = local6
                Else
                    createsubtitlesmsg(local0\Field0, local0\Field2, trim(local3), local0\Field8, local0\Field4, local0\Field5, local0\Field6)
                    local3 = ""
                EndIf
            Wend
            Delete local0
        EndIf
    Next
    local10 = (fps\Field7[$00] / 7.0)
    For local9 = Each subtitlesmsg
        If ((Float len(local9\Field4)) > local9\Field11) Then
            local9\Field11 = (local9\Field11 + fps\Field7[$00])
            local9\Field10 = left(local9\Field4, (Int floor(local9\Field11)))
        EndIf
        local9\Field8 = (local9\Field8 - fps\Field7[$00])
        If (0.0 > local9\Field8) Then
            local9\Field9 = max((local9\Field9 - local10), 0.0)
            If (0.0 >= local9\Field9) Then
                Delete local9
            EndIf
        Else
            local9\Field9 = min(1.0, (local9\Field9 + local10))
        EndIf
    Next
    Return $00
End Function
