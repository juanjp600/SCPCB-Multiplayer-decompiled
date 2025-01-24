Function rendermenutextboxes%()
    Local local0.menutextbox
    For local0 = Each menutextbox
        color($FF, $FF, $FF)
        setfontex(fo\Field0[local0\Field5])
        textex((Int (((Float (local0\Field2 Sar $01)) * local0\Field6) + (Float local0\Field0))), (local0\Field1 + (local0\Field3 Sar $01)), local0\Field4, (1.0 = local0\Field6), $01)
    Next
    Return $00
End Function
