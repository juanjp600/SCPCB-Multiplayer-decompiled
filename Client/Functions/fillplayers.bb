Function fillplayers%(arg0.players)
    Select arg0\Field49
        Case model_035
            arg0\Field110 = "SCP-035"
        Case model_049
            arg0\Field110 = "SCP-049"
        Case model_zombie
            arg0\Field110 = "SCP-049-2"
        Case model_096
            arg0\Field110 = "SCP-096"
        Case model_106
            arg0\Field110 = "SCP-106"
        Case model_173
            arg0\Field110 = "SCP-173"
        Case model_860
            arg0\Field110 = "SCP-860"
        Case model_939
            arg0\Field110 = "SCP-939"
        Case model_966
            arg0\Field110 = "SCP-966"
        Default
            arg0\Field110 = ""
    End Select
    Return $00
End Function
