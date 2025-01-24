Function setfontex%(arg0%)
    Local local0$
    local0 = "Default"
    Select arg0
        Case fo\Field0[$00]
            local0 = "Default"
        Case fo\Field0[$01]
            local0 = "Default_Big"
        Case fo\Field0[$02]
            local0 = "Digital"
        Case fo\Field0[$03]
            local0 = "Digital_Big"
        Case fo\Field0[$04]
            local0 = "Journal"
        Case fo\Field0[$05]
            local0 = "Console"
        Case fo\Field0[$06]
            local0 = "Credits"
        Case fo\Field0[$07]
            local0 = "Credits_Big"
        Case fo\Field0[$08]
            local0 = "Tahoma"
        Case fo\Field0[$09]
            local0 = "Icons"
    End Select
    textoffset = (Int getfilelocalstring("Data\fonts.ini", local0, "Offset", "", $01))
    setfont(arg0)
    Return $00
End Function
