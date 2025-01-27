Function renderconsole%()
    Local local0.consolemsg
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5$
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10#
    Local local11%
    If (opt\Field31 = $00) Then
        Return $00
    EndIf
    catcherrors("RenderConsole()")
    If (consoleopen <> 0) Then
        local6 = (Int (26.0 * menuscale))
        setfontex(fo\Field0[$05])
        local1 = $00
        local2 = (Int ((Float opt\Field50) - (300.0 * menuscale)))
        local3 = opt\Field49
        local4 = (Int (270.0 * menuscale))
        renderframe(local1, local2, local3, (Int ((30.0 * menuscale) + (Float local4))), $00, $00, $00)
        local7 = $00
        local8 = $00
        For local0 = Each consolemsg
            local7 = (Int ((15.0 * menuscale) + (Float local7)))
        Next
        local8 = (Int min((((Float local4) / (Float local7)) * (Float local4)), (Float local4)))
        local7 = (Int max((Float local7), (Float local4)))
        consoleinbar = mouseon(((local1 + local3) - local6), local2, local6, local4)
        local9 = (($14 * consoleinbar) + $32)
        color(local9, local9, local9)
        rect(((local1 + local3) - local6), local2, local6, local4, $01)
        consoleinbox = mouseon((Int ((Float (local1 + local3)) - (23.0 * menuscale))), (Int (((consolescroll * (Float local8)) / (Float local4)) + (Float ((local2 + local4) - local8)))), (Int (20.0 * menuscale)), local8)
        local9 = ((($50 * consoleinbox) + ($37 * consolescrolldragging)) + $78)
        color(local9, local9, local9)
        rect((Int ((Float (local1 + local3)) - (23.0 * menuscale))), (Int (((consolescroll * (Float local8)) / (Float local4)) + (Float ((local2 + local4) - local8)))), (Int (20.0 * menuscale)), local8, $01)
        color($FF, $FF, $FF)
        local10 = (((Float (local2 + local4)) - (25.0 * menuscale)) - consolescroll)
        local11 = $00
        For local0 = Each consolemsg
            local11 = (local11 + $01)
            If (local11 > $3E8) Then
                Delete local0
            Else
                If ((((Float local2) <= local10) And (local10 < ((Float (local2 + local4)) - (20.0 * menuscale)))) <> 0) Then
                    If (local0 = consolereissue) Then
                        color((local0\Field2 Sar $02), (local0\Field3 Sar $02), (local0\Field4 Sar $02))
                        rect(local1, (Int (local10 - (2.0 * menuscale))), (Int ((Float local3) - (30.0 * menuscale))), (Int (24.0 * menuscale)), $01)
                    EndIf
                    color(local0\Field2, local0\Field3, local0\Field4)
                    If (local0\Field1 <> 0) Then
                        local5 = ("> " + local0\Field0)
                    Else
                        local5 = local0\Field0
                    EndIf
                    textex((Int ((20.0 * menuscale) + (Float local1))), (Int local10), local5, $00, $00)
                EndIf
                local10 = (local10 - (15.0 * menuscale))
            EndIf
        Next
        color($FF, $FF, $FF)
        rendermenuinputboxes()
        rendercursor()
    EndIf
    setfontex(fo\Field0[$00])
    catcherrors("Uncaught: RenderConsole()")
    Return $00
End Function
