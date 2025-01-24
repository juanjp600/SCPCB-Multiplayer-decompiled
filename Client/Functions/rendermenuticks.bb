Function rendermenuticks%()
    Local local0.menutick
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    local1 = (Int (20.0 * menuscale))
    local2 = (Int (20.0 * menuscale))
    For local0 = Each menutick
        If (local0\Field3 <> 0) Then
            local3 = menugray
        Else
            local3 = menuwhite
        EndIf
        rendertiledimagerect(local3, (local0\Field0 Mod $100), (local0\Field1 Mod $100), $200, $200, local0\Field0, local0\Field1, local1, local2)
        local4 = mouseon(local0\Field0, local0\Field1, local1, local2)
        local5 = ($32 * local4)
        local6 = ($32 * local4)
        local7 = ($32 * local4)
        color(local5, local6, local7)
        rect((local0\Field0 + $02), (local0\Field1 + $02), (local1 - $04), (local2 - $04), $01)
        If (local0\Field2 <> 0) Then
            If (local4 <> 0) Then
                local5 = (Int ((Float local5) * 5.1))
                local6 = (Int ((Float local6) * 5.1))
                local7 = (Int ((Float local7) * 5.1))
            Else
                local5 = (local5 + $C8)
                local6 = (local6 + $C8)
                local7 = (local7 + $C8)
            EndIf
            color(local5, local6, local7)
            rendertiledimagerect(local3, (local0\Field0 Mod $100), (local0\Field1 Mod $100), $200, $200, (local0\Field0 + $04), (local0\Field1 + $04), (local1 - $08), (local2 - $08))
        EndIf
        color($FF, $FF, $FF)
    Next
    Return $00
End Function
