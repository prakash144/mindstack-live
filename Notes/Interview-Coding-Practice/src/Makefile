# Makefile for MySQL service management

# Variables
MYSQL_USER = root

# Default command (help)
help:
	@echo "Usage:"
	@echo "    make start       Start MySQL service"
	@echo "    make stop        Stop MySQL service"
	@echo "    make secure      Secure MySQL installation"
	@echo "    make connect     Connect to MySQL as root user"

# Step 1: Start MySQL Service
start:
	@echo "Starting MySQL service..."
	brew services start mysql
	@echo "MySQL service started."

# Step 2: Stop MySQL Service
stop:
	@echo "Stopping MySQL service..."
	brew services stop mysql
	@echo "MySQL service stopped."

# Step 3: Secure MySQL Installation
secure:
	@echo "Securing MySQL installation..."
	mysql_secure_installation

# Step 4: Connect to MySQL
connect:
	@echo "Connecting to MySQL as $(MYSQL_USER)..."
	mysql -u $(MYSQL_USER) -p
