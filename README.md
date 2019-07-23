# zk-navmenu

Free and open source navigation menu for the ZK 7 CE framework

## Maven Install

Add the folowing repository
```xml
<repository>
        <id>oss-sonatype</id>
        <name>oss-sonatype</name>
        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
</repository>
```

Dependency
```xml
<dependency>
	<groupId>org.sinnlabs.ui.zk</groupId>
	<artifactId>zk-navmenu</artifactId>
	<version>0.0.3</version>
</dependency>
```

## Usage

```xml
<sidemenu id="mnuMain" logo="Main Menu" width="300px" vflex="1">
	<sidemenugroup id="mnuTables" label="Tables" icon="z-icon-table">
	</sidemenugroup>
	<sidemenugroup id="mnuSystemGroup" label="System" icon="glyphicon glyphicon-cog">
		<sidemenuitem id="mnuIndex" label="Index" href="index.zul" target="frMain"/>
		<sidemenuitem id="mnuTest" label="Test" />
	</sidemenugroup>
</sidemenu>
```