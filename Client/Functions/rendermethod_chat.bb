Function rendermethod_chat%(arg0%)
    Local local0.chatmessage
    Local local1.ui_layer
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6#
    Local local7%
    local1 = (Object.ui_layer ui_layer[$01])
    local2 = (local1\Field2 + imenuscale[$05])
    local3 = local1\Field3
    local4 = ((arg0 - imenuscale[$05]) + local3)
    local5 = (((arg0 - imenuscale[$19]) - chatscroll) + local3)
    setcolorraw($FFFFFF)
    local7 = $01
    For local0 = Each chatmessage
        local0\Field2 = max((local0\Field2 - fpsfactor), 0.0)
        If (local5 < local3) Then
            Exit
        EndIf
        If (local5 < local4) Then
            local6 = 1.0
            If (networkserver\Field19 = $00) Then
                local6 = (min((local0\Field2 * 0.5), 255.0) / 255.0)
            EndIf
            If (0.0 < local6) Then
                setcolorex((Int (255.0 * local6)), (Int (255.0 * local6)), (Int (255.0 * local6)))
                If (local0\Field4 <> 0) Then
                    limitformattext((Float local2), (Float local5), local0\Field0, (Float (chatwidth - imenuscale[$1E])), $00, $00, local6, $00)
                Else
                    limittext(local0\Field0, local2, local5, (chatwidth - imenuscale[$1E]), $01, $00)
                EndIf
            EndIf
        EndIf
        local5 = (local5 - imenuscale[$1E])
    Next
    local7 = $00
    Return $00
End Function
