Function rendermenuslidebars%()
    Local local0.menuslidebar
    Local local1%
    Local local2%
    Local local3%
    For local0 = Each menuslidebar
        local1 = $FF
        local2 = $FF
        local3 = $FF
        If (mouseon(local0\Field0, local0\Field1, (Int ((Float local0\Field2) + (14.0 * menuscale))), (Int (20.0 * menuscale))) <> 0) Then
            local1 = $00
            local2 = $C8
            local3 = $00
        EndIf
        color(local1, local2, local3)
        rect(local0\Field0, local0\Field1, (Int ((Float local0\Field2) + (14.0 * menuscale))), (Int (20.0 * menuscale)), $00)
        drawblock(blinkmeterimg, (Int (((((Float local0\Field2) * local0\Field3) / 100.0) + (Float local0\Field0)) + (3.0 * menuscale))), (Int ((Float local0\Field1) + (3.0 * menuscale))), $00)
        color($AA, $AA, $AA)
        setfontex(fo\Field0[$00])
        textex((Int ((Float local0\Field0) - (50.0 * menuscale))), (Int ((Float local0\Field1) + (5.0 * menuscale))), getlocalstring("options", "slider.low"), $00, $00)
        textex((Int ((Float (local0\Field0 + local0\Field2)) + (34.0 * menuscale))), (Int ((Float local0\Field1) + (5.0 * menuscale))), getlocalstring("options", "slider.high"), $00, $00)
    Next
    Return $00
End Function
