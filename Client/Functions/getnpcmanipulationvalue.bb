Function getnpcmanipulationvalue$(arg0$, arg1$, arg2$, arg3%)
    Local local0$
    local0 = inigetstring("Data\NPCBones.ini", arg0, ((arg1 + "_") + arg2), "", $01)
    Select arg3
        Case $00
            Return local0
        Case $01
            Return (Str (Int local0))
        Case $02
            Return (Str (Float local0))
        Case $03
            Return (Str stringtoboolean(local0, $00))
    End Select
    Return ""
End Function
