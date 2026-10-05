Function rendermethod_console%(arg0%, arg1%)
    Local local0%
    Local local1%
    Local local2.ui_layer
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9.consolemsg
    Local local10%
    Local local11%
    Local local12%
    local2 = (Object.ui_layer ui_layer[$00])
    local3 = local2\Field2
    local4 = local2\Field3
    setfontex(fonts[$05]\Field0)
    local5 = ((- arg1) / imenuscale[$0F])
    local6 = ((arg0 / imenuscale[$0F]) + $03)
    local7 = ((- arg1) / imenuscale[$0F])
    local1 = ((arg0 - imenuscale[$1E]) - ((imenuscale[$0F] * local7) + arg1))
    local8 = $00
    local9 = (First consolemsg)
    While (((local9 <> Null) And (local6 > $00)) <> 0)
        If (local5 > $00) Then
            local5 = (local5 - $01)
        Else
            local6 = (local6 - $01)
            local8 = (local8 + $01)
            If (local8 <= $3E8) Then
                If (((local1 >= (- imenuscale[$1E])) And (local1 < (imenuscale[$1E] + arg0))) <> 0) Then
                    If (local9 = consolereissue) Then
                        local10 = ((local9\Field2 Shr $10) And $FF)
                        local11 = ((local9\Field2 Shr $08) And $FF)
                        local12 = (local9\Field2 And $FF)
                        setcolorex((Int ((Float local10) * 0.25)), (Int ((Float local11) * 0.25)), (Int ((Float local12) * 0.25)))
                        rect(local3, ((local4 + local1) - imenuscale[$02]), (graphicwidth - imenuscale[$1E]), imenuscale[$11], $01)
                    EndIf
                    setcolorraw(local9\Field2)
                    local0 = (imenuscale[$0F] + local3)
                    If (local9\Field1 <> 0) Then
                        text(local0, (local4 + local1), "> ", $00, $00)
                        text((imenuscale[$14] + local0), (local4 + local1), local9\Field0, $00, $00)
                    Else
                        text(local0, (local4 + local1), local9\Field0, $00, $00)
                    EndIf
                EndIf
                local1 = (local1 - imenuscale[$0F])
            EndIf
        EndIf
        local9 = (After local9)
    Wend
    Return $00
End Function
