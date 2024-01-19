Function getnpcmanipulationvalue$(arg0$, arg1$, arg2$, arg3%)
    Local local0$
    local0 = getinistring("Data\NPCBones.ini", arg0, ((arg1 + "_") + arg2), "")
    Select arg3
        Case $00
            Return local0
        Case $01
            Return (Str (Int local0))
        Case $02
            Return (Str (Float local0))
        Case $03
            If (((local0 = "true") Or (local0 = "1")) <> 0) Then
                Return "1"
            Else
                Return "0"
            EndIf
    End Select
    Return ""
End Function
