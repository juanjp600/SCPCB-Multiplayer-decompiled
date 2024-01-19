Function mp_isafriend%(arg0%, arg1%)
    Select arg0
        Case model_173,model_106,model_939,model_966,model_049,model_zombie,model_096,model_860,model_035,$00
            Select arg1
                Case model_173,model_106,model_939,model_966,model_049,model_zombie,model_096,model_860,model_035,$00
                    Return $01
                Default
                    Return $00
            End Select
        Case classd_model,haos_model
            Select arg1
                Case classd_model,haos_model
                    Return $01
                Default
                    Return $00
            End Select
        Case ntf_model,guard_model,janitor_model,worker_model,scientist_model,model_clerk
            Select arg1
                Case ntf_model,guard_model,janitor_model,worker_model,scientist_model,model_clerk
                    Return $01
                Default
                    Return $00
            End Select
        Case janitor_model,worker_model,scientist_model,model_clerk
            Select arg1
                Case janitor_model,worker_model,scientist_model,model_clerk
                    Return $01
                Default
                    Return $00
            End Select
    End Select
    Return $00
    Return $00
End Function
