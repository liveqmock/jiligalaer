INSERT INTO `CLOUD_MDM_CPU_SOLN` VALUES ('8aa501824186943301418694720e0000', '2b264262-5139-4255-a189-3032bb26eda2', 'NetRate1M', 'NetRate1M', '1', '2000', '1024', '2013-10-05 12:57:04', '1'), ('8aa501824186943301418694722f0001', '323b6c25-5a9d-4a12-b3fd-1b3c1e25cc45', '4c8g', '4cg', '4', '3000', '8192', '2013-10-05 12:57:04', '1'), ('8aa50182418694330141869472300002', '291b6c15-d4dd-4bbf-baad-45e8b0c375cf', 'Large Instance 2 CPU @ 2.0GHz + 4GB Mem With HA', 'Large Instance 2 CPU @ 2.0GHz + 4GB Mem With HA', '2', '2000', '4096', '2013-10-05 12:57:04', '1'), ('8aa50182418694330141869472310003', '9bc5a94c-d71d-446e-a36b-d45572acce5e', 'Medium Instance', 'Medium Instance', '1', '1000', '1024', '2013-10-05 12:57:04', '1'), ('8aa50182418694330141869472310004', '53c0b79f-825c-4ac1-97c5-25752fe34b39', 'Small Instance', 'Small Instance', '1', '500', '512', '2013-10-05 12:57:04', '1');


INSERT INTO `CLOUD_MDM_DISK_SOLN` VALUES ('8aa50182418694330141869473e60005', 'acbf5c5f-ef06-4090-9f67-98d9dda895c4', null, 'Small Disk, 5 GB', 'Small', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869473e70006', 'dccf8dba-86b7-4f76-8bc5-dc19db8566b9', null, 'Medium Disk, 20 GB', 'Medium', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869473e80007', '1dbfabf1-e24d-49ff-a6da-cd4a453074bd', null, 'Large Disk, 100 GB', 'Large', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869473e80008', 'f33d2e49-b850-4512-887e-2cef30fb6f71', null, 'Custom Disk', 'Custom', '2013-10-05 12:57:05', '1');

INSERT INTO `CLOUD_MDM_IP` VALUES ('8aa50182418694330141869475250009', '5b955e8c-ba34-421a-a993-618f7fe07651', null, null, '172.16.21.69', 'b6d3af13-9d0e-4dc0-ba86-edb26504dbc6', '2013-10-05 12:57:05', '1'), ('8aa5018241869433014186947526000a', 'fa85b65e-f8fc-4a75-8020-42a3e8f8237a', null, null, '172.16.21.68', '3449c80b-437b-49dc-a796-06b7bc585bb4', '2013-10-05 12:57:05', '1'), ('8aa5018241869433014186947526000b', 'e71d4624-8b39-48a7-9828-806bfc0fb5be', null, null, '172.16.21.67', null, '2013-10-05 12:57:05', '1'), ('8aa5018241869433014186947526000c', '6f41ff6a-c8b8-48b0-acde-adfc5d36931c', null, null, '172.16.21.66', null, '2013-10-05 12:57:05', '1'), ('8aa5018241869433014186947527000d', '43264aee-7f59-4815-a75d-17394fafd480', null, null, '172.16.21.65', null, '2013-10-05 12:57:05', '1'), ('8aa5018241869433014186947527000e', 'acfa1542-a677-4d13-ae91-6a4609a73e79', null, null, '172.16.21.64', null, '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869475d3000f', '8b938a68-4a98-409e-b493-2e34191cf180', null, null, '172.16.21.63', null, '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869475d40010', '6560b35b-6065-4469-9b3d-e3d1daac4e34', null, null, '172.16.21.62', null, '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869475d40011', '842d2241-6b2d-4fca-ac28-f80f3098b6a1', null, null, '172.16.21.61', null, '2013-10-05 12:57:05', '1');


INSERT INTO `CLOUD_MDM_NETWORK` VALUES ('8aa501824186976401418697cb2a0000', '9418de48-c61f-4bec-a563-d067b05a1604', '1MNet', '1MNet', 'Guest', '10.1.1.1', '255.255.255.0', '10.1.1.0/24', 'c7650b06-4c5b-4077-a53c-6103aba25f69', '64b4f9c8-b0d9-4e5c-8d2a-aed75cb22d8e', 'false', 'Implemented', '9418de48-c61f-4bec-a563-d067b05a1604', 'vlan://1133', '8.8.8.8', 'Isolated', '1133', 'Account', '5f65d860-07ad-49b9-bbe6-f932a4984b5b', 'false', 'false', 'true', '2013-10-05 12:57:06', '1'), ('8aa501824186976401418697cb360001', 'ce0f626b-be98-446f-bb9e-0959e1cc28d1', 'Default Network', 'Default Network', 'Guest', '10.1.1.1', '255.255.255.0', '10.1.1.0/24', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'a672210d-7788-4445-97ff-5a8c50188c8d', 'false', 'Allocated', 'ce0f626b-be98-446f-bb9e-0959e1cc28d1', null, '8.8.8.8', 'Isolated', null, 'Account', '5f65d860-07ad-49b9-bbe6-f932a4984b5b', 'false', 'false', 'true', '2013-10-05 12:57:06', '1'), ('8aa501824186976401418697cb380002', '5bd539f0-34ea-4c9f-a385-21715dfe9aae', '1m', '1m', 'Guest', '10.1.1.1', '255.255.255.0', '10.1.1.0/24', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'a672210d-7788-4445-97ff-5a8c50188c8d', 'false', 'Allocated', '5bd539f0-34ea-4c9f-a385-21715dfe9aae', null, '8.8.8.8', 'Isolated', null, 'Account', '5f65d860-07ad-49b9-bbe6-f932a4984b5b', 'false', 'false', 'true', '2013-10-05 12:57:06', '1'), ('8aa501824186976401418697cb390003', 'e5dde9b2-b342-4216-92ad-ccad3d3d3dfe', 'ADNET-1M', 'ADNET-1M', 'Guest', '10.1.1.1', '255.255.255.0', '10.1.1.0/24', 'c7650b06-4c5b-4077-a53c-6103aba25f69', '64b4f9c8-b0d9-4e5c-8d2a-aed75cb22d8e', 'false', 'Allocated', 'e5dde9b2-b342-4216-92ad-ccad3d3d3dfe', null, '8.8.8.8', 'Isolated', null, 'Account', '5f65d860-07ad-49b9-bbe6-f932a4984b5b', 'false', 'false', 'true', '2013-10-05 12:57:06', '1');


INSERT INTO `CLOUD_MDM_NETWORK_SOLN` VALUES ('8aa50182418694330141869477d50012', '015b9c0e-4543-45e8-8175-cb2cc85f617d', 'DefaultSharedNetworkOffering', 'Offering for Shared networks', '1', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869477d60013', 'a672210d-7788-4445-97ff-5a8c50188c8d', 'DefaultIsolatedNetworkOfferingWithSourceNatService', 'Offering for Isolated networks with Source Nat service enabled', '1', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869477d60014', '8d964a4e-4472-4c4f-b447-682a85703279', 'DefaultSharedNetworkOfferingWithSGService', 'Offering for Shared Security group enabled networks', '1', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869477d70015', '208242a5-864e-4b52-85c0-15109dd8941b', 'DefaultIsolatedNetworkOffering', 'Offering for Isolated networks with no Source Nat service', '1', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869477d70016', '60a432b3-99d6-43ce-894f-1db78dfed779', 'DefaultSharedNetscalerEIPandELBNetworkOffering', 'Offering for Shared networks with Elastic IP and Elastic LB capabilities', '1', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869477d80017', '81230f50-9dc6-4f75-b33e-584ef7480785', 'DefaultIsolatedNetworkOfferingForVpcNetworksNoLB', 'Offering for Isolated Vpc networks with Source Nat service enabled and LB service Disabled', '1', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869477d80018', '018ab553-54c2-4e58-9fe9-615c210db213', 'Test Basic', '2 NICs', '10', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869477d80019', '218e99ef-08b7-4f03-8213-98bec00dd93a', 'DefaultIsolatedNetworkOfferingForVpcNetworks', 'Offering for Isolated Vpc networks with Source Nat service enabled', '1', '2013-10-05 12:57:05', '1'), ('8aa50182418694330141869477d9001a', '64b4f9c8-b0d9-4e5c-8d2a-aed75cb22d8e', 'Test-For-1M-Rate', 'Test-For-1M-Rate', '1', '2013-10-05 12:57:05', '1');


INSERT INTO `CLOUD_MDM_NIC` VALUES ('8aa50182418694330141869479fc0021', 'f5217909-3547-4b36-ac8a-f3862bbdc659', '9418de48-c61f-4bec-a563-d067b05a1604', '255.255.255.0', '10.1.1.1', '10.1.1.209', 'vlan://1133', 'vlan://1133', 'Guest', 'Isolated', 'true', '02:00:4b:32:00:03', null, '3449c80b-437b-49dc-a796-06b7bc585bb4', '2013-10-05 12:57:06', '1'), ('8aa50182418694330141869479fd0022', 'a7b58016-eaba-4bca-9025-01771710d26b', '9418de48-c61f-4bec-a563-d067b05a1604', '255.255.255.0', '10.1.1.1', '10.1.1.192', null, null, 'Guest', 'Isolated', 'true', '02:00:7a:ab:00:01', null, '481b6127-fe35-4919-8ccc-28eb9d57722b', '2013-10-05 12:57:06', '1'), ('8aa50182418694330141869479fd0023', 'b82df6e1-ae70-472c-8a41-ca1e5b50f901', 'ce0f626b-be98-446f-bb9e-0959e1cc28d1', '255.255.255.0', '10.1.1.1', '10.1.1.237', null, null, 'Guest', 'Isolated', 'true', '02:00:69:39:00:01', null, 'b6d3af13-9d0e-4dc0-ba86-edb26504dbc6', '2013-10-05 12:57:06', '1'), ('8aa50182418694330141869479fe0024', '46bf92a8-81a0-491c-aacc-9b00cc7e7ef3', '5bd539f0-34ea-4c9f-a385-21715dfe9aae', '255.255.255.0', '10.1.1.1', '10.1.1.181', null, null, 'Guest', 'Isolated', 'true', '02:00:44:6b:00:01', null, 'd6333cd4-859b-4ee8-bd3a-2662f3df261f', '2013-10-05 12:57:06', '1'), ('8aa50182418694330141869479ff0025', '82065376-b1c0-4c79-aa96-3848de171bfa', 'e5dde9b2-b342-4216-92ad-ccad3d3d3dfe', '255.255.255.0', '10.1.1.1', '10.1.1.161', null, null, 'Guest', 'Isolated', 'false', '02:00:70:70:00:06', null, 'd6333cd4-859b-4ee8-bd3a-2662f3df261f', '2013-10-05 12:57:06', '1');


INSERT INTO `CLOUD_MDM_TEMPLATE` VALUES ('8aa50182418694330141869478c4001b', '4', 'CentOS 5.5(64-bit) no GUI (KVM)', 'CentOS 5.5(64-bit) no GUI (KVM)', null, '2013-10-05 12:57:06', '1'), ('8aa50182418694330141869478c4001c', '238ccebf-fe33-4d28-9d7c-4661a815a119', 'Win2003', 'Win2003', null, '2013-10-05 12:57:06', '1');


INSERT INTO `CLOUD_MDM_VM` VALUES ('8aa50182418694330141869479cf001d', '3449c80b-437b-49dc-a796-06b7bc585bb4', null, null, '3449c80b-437b-49dc-a796-06b7bc585bb4', '3449c80b-437b-49dc-a796-06b7bc585bb4', '9bc5a94c-d71d-446e-a36b-d45572acce5e', '1', '1000', '1024', '1.13%', '15601', '13592', 'fa85b65e-f8fc-4a75-8020-42a3e8f8237a', '172.16.21.68', '4', 'CentOS 5.5(64-bit) no GUI (KVM)', 'CentOS 5.5(64-bit) no GUI (KVM)', 'ADVZone', '2013-10-05 12:57:06', '1'), ('8aa50182418694330141869479d0001e', '481b6127-fe35-4919-8ccc-28eb9d57722b', null, null, 'Withoutcompute', 'Withoutcompute', '9bc5a94c-d71d-446e-a36b-d45572acce5e', '1', '1000', '1024', '1.12%', '18927', '707', null, null, '4', 'CentOS 5.5(64-bit) no GUI (KVM)', 'CentOS 5.5(64-bit) no GUI (KVM)', 'ADVZone', '2013-10-05 12:57:06', '1'), ('8aa50182418694330141869479d1001f', 'b6d3af13-9d0e-4dc0-ba86-edb26504dbc6', null, null, 'b6d3af13-9d0e-4dc0-ba86-edb26504dbc6', 'b6d3af13-9d0e-4dc0-ba86-edb26504dbc6', '2b264262-5139-4255-a189-3032bb26eda2', '1', '2000', '1024', '1.13%', '6012', '203', '5b955e8c-ba34-421a-a993-618f7fe07651', '172.16.21.69', '4', 'CentOS 5.5(64-bit) no GUI (KVM)', 'CentOS 5.5(64-bit) no GUI (KVM)', 'ADVZone', '2013-10-05 12:57:06', '1'), ('8aa50182418694330141869479d20020', 'd6333cd4-859b-4ee8-bd3a-2662f3df261f', null, null, 'd6333cd4-859b-4ee8-bd3a-2662f3df261f', 'd6333cd4-859b-4ee8-bd3a-2662f3df261f', '2b264262-5139-4255-a189-3032bb26eda2', '1', '2000', '1024', '1.16%', '29', '83', null, null, '4', 'CentOS 5.5(64-bit) no GUI (KVM)', 'CentOS 5.5(64-bit) no GUI (KVM)', 'ADVZone', '2013-10-05 12:57:06', '1');

INSERT INTO `CLOUD_MDM_VOLUME` VALUES ('8aa501824186f932014186f9e9cf0000', '846c4570-40d5-4716-acb5-e90c86a9b3cb', 'ROOT-350', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'ROOT', '0', '3449c80b-437b-49dc-a796-06b7bc585bb4', '8589934592', '2013-08-16 20:58:07', null, 'Ready', 'admin', '1', 'ROOT', 'shared', 'KVM', 'AD_Primary01', 'false', '9bc5a94c-d71d-446e-a36b-d45572acce5e', 'true', null, null, '2013-10-05 12:57:07', '1'), ('8aa501824186f932014186f9e9ed0001', '453881f7-a746-457a-b440-dc2909f6d812', 'ROOT-348', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'ROOT', '0', '481b6127-fe35-4919-8ccc-28eb9d57722b', '8589934592', '2013-08-16 20:45:14', null, 'Ready', 'admin', '1', 'ROOT', 'shared', 'KVM', 'AD_Primary01', 'false', '9bc5a94c-d71d-446e-a36b-d45572acce5e', 'true', null, null, '2013-10-05 12:57:07', '1'), ('8aa501824186f932014186f9e9ee0002', '27a97d49-2ef7-46a1-b2a2-ab59744c13b3', 'ROOT-346', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'ROOT', '0', 'b6d3af13-9d0e-4dc0-ba86-edb26504dbc6', '8589934592', '2013-08-16 20:27:44', null, 'Ready', 'admin', '1', 'ROOT', 'shared', 'KVM', 'AD_Primary01', 'false', '2b264262-5139-4255-a189-3032bb26eda2', 'true', null, null, '2013-10-05 12:57:07', '1'), ('8aa501824186f932014186f9e9ef0003', 'fad05f6d-5bc2-40ef-960e-2e1ef4cd462e', 'ROOT-343', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'ROOT', '0', 'd6333cd4-859b-4ee8-bd3a-2662f3df261f', '8589934592', '2013-08-16 20:15:50', null, 'Ready', 'admin', '1', 'ROOT', 'shared', 'KVM', 'AD_Primary01', 'false', '2b264262-5139-4255-a189-3032bb26eda2', 'true', null, null, '2013-10-05 12:57:07', '1'), ('8aa501824186f932014186f9e9f00004', 'd35b6fbf-d052-4ad6-80e1-5c8c85e13594', 'ShareDisk', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'DATADISK', null, null, '5368709120', '2013-07-22 10:10:26', null, 'Ready', 'admin', '1', 'ROOT', 'shared', 'KVM', 'AD_Primary01', 'false', null, 'true', 'acbf5c5f-ef06-4090-9f67-98d9dda895c4', null, '2013-10-05 12:57:07', '1'), ('8aa501824186f932014186f9e9f20005', '708b21bb-cda9-47e1-9e5e-129cd27188d1', 'Data-qcow2', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'DATADISK', null, null, '1073741824', '2013-07-19 10:42:55', null, 'Uploaded', 'admin', '1', 'ROOT', 'shared', 'KVM', 'none', 'false', null, 'true', 'f33d2e49-b850-4512-887e-2cef30fb6f71', null, '2013-10-05 12:57:07', '1'), ('8aa501824186f932014186f9e9f30006', 'ee37d34e-5bec-44da-a247-82cf09832756', 'Data-In-Raw', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'DATADISK', null, null, '2147483648', '2013-07-19 10:38:32', null, 'Uploaded', 'admin', '1', 'ROOT', 'shared', 'Ovm', 'none', 'false', null, 'true', 'f33d2e49-b850-4512-887e-2cef30fb6f71', null, '2013-10-05 12:57:07', '1'), ('8aa501824186f932014186f9e9f60007', 'cc56da69-9055-4461-a183-44cb9d6abd3f', 'DATA-322', 'c7650b06-4c5b-4077-a53c-6103aba25f69', 'DATADISK', null, null, '57982058496', '2013-06-03 17:02:35', null, 'Ready', 'admin', '1', 'ROOT', 'shared', 'KVM', 'AD_Primary01', 'false', null, 'true', 'f33d2e49-b850-4512-887e-2cef30fb6f71', null, '2013-10-05 12:57:07', '1');

INSERT INTO `CLOUD_MDM_ZONE` VALUES ('8aa5018241869433014186947b6b0026', 'c7650b06-4c5b-4077-a53c-6103aba25f69', null, null, 'Advanced', '2013-10-05 12:57:06', '1');
