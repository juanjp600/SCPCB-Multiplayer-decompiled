Function rendermenubuttons%()
    Local local0.menubutton
    For local0 = Each menubutton
        rendermenubutton(local0)
    Next
    For local0 = Each menubutton
        local0\Field13 = $00
    Next
    Return $00
End Function
